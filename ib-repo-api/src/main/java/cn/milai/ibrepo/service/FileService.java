package cn.milai.ibrepo.service;

import cn.milai.common.decoupling.Resp;

/**
 * File 相关接口 Service
 * @author milai
 * @date 2020.02.01
 */
public interface FileService {

	/**
	 * 获取 drama 的数据
	 * @param dramaCode
	 * @return
	 */
	Resp<byte[]> getDrama(String dramaCode);

	/**
	 * 获取 drama 的资源文件数据
	 * @param dramaCode
	 * @return
	 */
	Resp<byte[]> getDramaRes(String dramaCode);

}
