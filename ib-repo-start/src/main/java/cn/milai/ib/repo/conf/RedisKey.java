package cn.milai.ib.repo.conf;

/**
 * 生成 Redis key 的常量类
 * 2020.01.28
 * @author milai
 */
public abstract class RedisKey {

	private RedisKey() {

	}

	public static final String EMAIL_TO_VALIDATE_CODE = "email.validate.code|";

	public static final String TOKEN_TO_ID = "token.id|";
	
	/**
	 * 已经发送邮箱验证码而暂时不能获取下一条邮件的锁 key
	 */
	public static final String EMAIL_SENT_LOCK = "email.sent.lock|";

}
