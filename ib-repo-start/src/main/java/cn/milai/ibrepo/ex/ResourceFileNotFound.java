package cn.milai.ibrepo.ex;

import cn.milai.ibrepo.IBRepoResp;

/**
 * 资源文件不存在
 * @author milai
 * @date 2020.02.01
 */
public class ResourceFileNotFound extends IBRepoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final IBRepoResp RESPONSE = IBRepoResp.RESOURCE_FILE_NOT_FOUND;

	public ResourceFileNotFound(String fileName) {
		super(RESPONSE.getCode(), String.format(RESPONSE.getDesc(), fileName));
	}

}
