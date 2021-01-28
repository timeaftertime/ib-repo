package cn.milai.ibrepo.ex;

/**
 * 邮箱验证码不存在或错误
 * @author milai
 * @date 2020.01.31
 */
public class EmailValidCodeError extends ParamInvalidException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailValidCodeError(String email) {
		super(String.format("邮箱 %s 的验证码错误", email));
	}

}
