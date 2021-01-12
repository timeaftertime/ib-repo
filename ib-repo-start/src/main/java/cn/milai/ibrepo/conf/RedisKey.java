package cn.milai.ibrepo.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户生成 Redis key 工具类
 * 2020.01.28
 * @author milai
 */
@Component
public class RedisKey {

	@Value("${spring.application.name}")
	private String appName;

	/**
	 * 邮箱验证码
	 * @param code
	 * @return
	 */
	public String emailAuthCode(String code) {
		return String.format("%s|emailAuthCode|%s", appName, code);
	}

	/**
	 * token 对应的 userId 
	 * @param token
	 * @return
	 */
	public String tokenToId(String token) {
		return String.format("%s|tokenToId|%s", appName, token);
	}

	/**
	 * 一定时间内已经发送过验证邮件的邮箱
	 * @param email
	 * @return
	 */
	public String emailSentLock(String email) {
		return String.format("%s|emailSentLock|%s", appName, email);
	}

}
