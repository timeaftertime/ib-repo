package cn.milai.ib.repo.service;

import cn.milai.ib.repo.model.Response;

/**
 * File 相关接口 Service
 * @author milai
 * @date 2020.02.01
 */
public interface FileService {

	/**
	 * 获取 character 对应 img 的数据
	 * @param characterCode
	 * @param status
	 * @return
	 */
	Response<byte[]> getCharacterImage(String characterCode, String status);

	/**
	 * 获取 character 对应 conf 的数据
	 * @param characterCode
	 * @return
	 */
	Response<byte[]> getCharacterConf(String characterCode);

	/**
	 * 获取 drama 的数据
	 * @param dramaCode
	 * @return
	 */
	Response<byte[]> getDrama(String dramaCode);

}
