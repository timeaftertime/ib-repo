package cn.milai.ib.repo.controller;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件相关前端接口
 * @author milai
 * @date 2020.02.01
 */
public interface FileController {

	/**
	 * 获取指定的 drama 文件
	 * @param response
	 * @param dramaCode
	 */
	void getDrama(HttpServletResponse response, String dramaCode);

	/**
	 * 获取指定的 drama 资源文件
	 * @param response
	 * @param dramaCode
	 */
	void getDramaRes(HttpServletResponse response, String dramaCode);
}
