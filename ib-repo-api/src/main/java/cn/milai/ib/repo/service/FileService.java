package cn.milai.ib.repo.service;

import cn.milai.ib.repo.model.Response;

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
	Response<byte[]> getDrama(String dramaCode);

	/**
	 * 获取 drama 的资源文件数据
	 * @param dramaCode
	 * @return
	 */
	Response<byte[]> getDramaRes(String dramaCode);

}
