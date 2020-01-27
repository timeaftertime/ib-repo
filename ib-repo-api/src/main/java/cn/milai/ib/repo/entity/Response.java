package cn.milai.ib.repo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Controller 接口统一返回模型
 * 2020.01.27
 * @author milai
 * @see ResponseCode
 */
@Data
@AllArgsConstructor
public class Response<T> {

	/**
	 * 唯一标识
	 */
	private String code;

	/**
	 * 详细信息
	 */
	private String desc;

	/**
	 * 数据
	 */
	private T data;

	public static Response<?> fail(ResponseCode response) {
		return new Response<>(response.getCode(), response.getDesc(), null);
	}

}
