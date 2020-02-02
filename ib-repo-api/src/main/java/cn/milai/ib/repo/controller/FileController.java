package cn.milai.ib.repo.controller;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件相关前端接口
 * @author milai
 * @date 2020.02.01
 */
public interface FileController {

	/**
	 * 获取指定 character 的 gif 文件
	 * @param response
	 * @param characterCode
	 * @param status
	 */
	void getCharacterImage(HttpServletResponse response, String characterCode, String status);

	/**
	 * 获取指定 character 的 conf 文件
	 * @param response
	 * @param characterCode
	 */
	void getCharacterConf(HttpServletResponse response, String characterCode);

	/**
	 * 获取指定的 drama 文件
	 * @param response
	 * @param dramaCode
	 */
	void getDrama(HttpServletResponse response, String dramaCode);
}
