package cn.milai.ib.repo.ex;

import cn.milai.ib.repo.model.ResponseCode;

/**
 * 参数不合法的异常
 * @author milai
 * @date 2020.01.31
 */
public class ParamInvalidException extends IBRepoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamInvalidException(String desc) {
		super(ResponseCode.PARAM_INVALID.getCode(), desc);
	}

}
