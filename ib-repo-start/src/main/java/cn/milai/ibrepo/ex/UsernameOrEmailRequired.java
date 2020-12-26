package cn.milai.ibrepo.ex;

/**
 * 用户名和邮箱不能同时为空
 * @author milai
 * @date 2020.01.31
 */
public class UsernameOrEmailRequired extends ParamInvalidException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameOrEmailRequired() {
		super("用户名和邮箱不能同时为空");
	}

}
