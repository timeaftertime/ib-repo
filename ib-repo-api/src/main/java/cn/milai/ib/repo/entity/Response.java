package cn.milai.ib.repo.entity;

import lombok.Data;

/**
 * Controller 接口统一返回模型 2020.01.27
 * 
 * @author milai
 * @see ResponseCode
 */
@Data
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

	public boolean isSuccess() {
		return code == ResponseCode.SUCCESS.getCode();
	}

	private Response(String code, String desc, T data) {
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

	private Response(ResponseCode response) {
		this(response.getCode(), response.getDesc(), null);
	}

	public static Response<Void> fail(ResponseCode response) {
		return new Response<>(response);
	}

	public static Response<Void> fail(ResponseCode response, String args) {
		return new Response<>(response.getCode(), String.format(response.getDesc(), args), null);
	}

	public static Response<Void> success() {
		return new Response<>(ResponseCode.SUCCESS);
	}

}
