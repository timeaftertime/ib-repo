package cn.milai.ib.repo.ex;

/**
 * 邮箱已存在
 * @author milai
 * @date 2020.01.31
 */
public class EmailAlreadyExists extends ParamInvalidException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailAlreadyExists(String email) {
		super(String.format("邮箱 %s 已存在", email));
	}

}
