package cn.milai.ibrepo.ex;

import cn.milai.ibrepo.IBRepoResp;

/**
 * ib-repo 所有异常类的基类
 * @date 2020.01.27
 * @author milai
 */
public class IBRepoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String desc;

	public IBRepoException(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public IBRepoException(IBRepoResp response) {
		this(response.getCode(), response.getDesc());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
