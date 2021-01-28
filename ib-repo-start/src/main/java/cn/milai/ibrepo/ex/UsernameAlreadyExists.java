package cn.milai.ibrepo.ex;

/**
 * 用户名已经存在
 * @author milai
 * @date 2020.01.31
 */
public class UsernameAlreadyExists extends ParamInvalidException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExists(String username) {
		super("用户名 %s 已存在");
	}

}
