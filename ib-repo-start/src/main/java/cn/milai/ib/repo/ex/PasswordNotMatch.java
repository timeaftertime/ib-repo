package cn.milai.ib.repo.ex;

/**
 * 用户名或邮箱与密码不匹配
 * @author milai
 * @date 2020.01.31
 */
public class PasswordNotMatch extends ParamInvalidException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordNotMatch() {
		super("用户名与密码不匹配");
	}

}
