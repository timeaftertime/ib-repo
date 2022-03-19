package cn.milai.ibrepo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import cn.milai.common.api.Resp;
import cn.milai.common.api.map.Mappers;
import cn.milai.common.base.Digests;
import cn.milai.common.base.Randoms;
import cn.milai.ibrepo.IBRepoResp;
import cn.milai.ibrepo.conf.RedisKey;
import cn.milai.ibrepo.dao.UserDAO;
import cn.milai.ibrepo.dao.po.UserPO;
import cn.milai.ibrepo.ex.EmailAlreadyExists;
import cn.milai.ibrepo.ex.EmailValidCodeError;
import cn.milai.ibrepo.ex.PasswordNotMatch;
import cn.milai.ibrepo.ex.UsernameAlreadyExists;
import cn.milai.ibrepo.ex.UsernameOrEmailRequired;
import cn.milai.ibrepo.service.dto.UserLoginDTO;
import cn.milai.ibrepo.service.dto.UserRegisterDTO;

/**
 * UserService 默认实现
 * @date 2020.01.28
 * @author milai
 */
@Service
public class UserServiceImpl implements UserService {

	private static final int VALICODE_LENGTH = 6;
	private static final int TOKEN_LENGTH = 16;
	private static final int EMAIL_SENT_WAIT_SECONDS = 60;
	private static final int VALIDATECODE_VALID_MINUTES = 10;

	@Autowired
	private RedisTemplate<String, String> redis;
	@Autowired
	private RedisKey redisKey;
	@Autowired
	private UserDAO userDAO;

	@Override
	public Resp<String> login(UserLoginDTO req) {
		if (req.getUsername() == null && req.getEmail() == null) {
			throw new UsernameOrEmailRequired();
		}
		UserPO user = null;
		if (req.getUsername() != null) {
			user = userDAO.selectByUsername(req.getUsername());
		} else if (req.getEmail() != null) {
			user = userDAO.selectByEmail(req.getEmail());
		}
		if (user == null) {
			throw new PasswordNotMatch();
		}
		if (!Digests.sha256(req.getPassword()).equals(user.getPassword())) {
			throw new PasswordNotMatch();
		}
		return Resp.success(createToken(user.getId()));
	}

	/**
	 * 构造并设置 user 对应的 token
	 * @param user
	 * @return
	 */
	private String createToken(long userId) {
		String token = nextToken(userId);
		while (!trySetToken(token, userId)) {
			token = nextToken(userId);
		}
		return token;
	}

	/**
	 * 尝试设置 token ，若设置成功，返回 true ，否则返回 false
	 * @param token
	 * @param userId
	 * @return
	 */
	private boolean trySetToken(String token, long userId) {
		return redis.opsForValue().setIfAbsent(redisKey.tokenToId(token), String.valueOf(userId)) != null;
	}

	/**
	 * 获取一个 userId 对应的 token
	 * @param userId
	 * @return
	 */
	private String nextToken(long userId) {
		return Digests.sha256(Randoms.fixedLowerDigit(4) + System.nanoTime() + userId).substring(0, TOKEN_LENGTH);
	}

	@Override
	public Resp<String> register(UserRegisterDTO req) {
		String key = redisKey.emailAuthCode(req.getEmail());
		if (!req.getValidateCode().equalsIgnoreCase(redis.opsForValue().get(key))) {
			throw new EmailValidCodeError(req.getEmail());
		}
		redis.delete(key);
		checkUsernameExists(req.getUsername());
		checkEmailExists(req.getEmail());
		// 检查完后出现的异步问题由数据库一致性来解决，不再加锁
		req.setPassword(Digests.sha256(req.getPassword()));
		UserPO user = Mappers.deep(req, UserPO.class);
		userDAO.insertUser(user);
		return Resp.success(createToken(user.getId()));
	}

	private void checkUsernameExists(String username) {
		if (userDAO.existsUsername(username)) {
			throw new UsernameAlreadyExists(username);
		}
	}

	private void checkEmailExists(String email) {
		if (userDAO.existsEmail(email)) {
			throw new EmailAlreadyExists(email);
		}
	}

	@Override
	public Resp<Void> sendValidateEmail(String email) {
		String lockKey = redisKey.emailSentLock(email);
		if (!redis.opsForValue().setIfAbsent(lockKey, "")) {
			// 防止设置锁过期时间失败而一直无法被解锁
			redis.expire(lockKey, Long.min(redis.getExpire(lockKey), EMAIL_SENT_WAIT_SECONDS), TimeUnit.SECONDS);
			return Resp.fail(IBRepoResp.EMAIL_CODE_SENT, String.valueOf(redis.getExpire(lockKey)));
		}
		redis.expire(lockKey, EMAIL_SENT_WAIT_SECONDS, TimeUnit.SECONDS);
		checkEmailExists(email);
		String key = redisKey.emailAuthCode(email);
		String value = Randoms.fixedLowerDigit(VALICODE_LENGTH);
		// TODO 发送邮件
		redis.opsForValue().set(key, value);
		redis.expire(lockKey, VALIDATECODE_VALID_MINUTES, TimeUnit.MINUTES);
		return Resp.success();
	}

}
