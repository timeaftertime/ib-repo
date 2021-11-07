package cn.milai.ibrepo;

import cn.milai.common.decoupling.RespCode;

/**
 * 返回状态枚举 
 * create 2020.01.27
 * 
 * @author milai
 */
public enum IBRepoResp implements RespCode {

	UNKNOWN_ERROR(1, "系统异常"),
	PARAM_INVALID(2, "%s"),
	EMAIL_CODE_SENT(3, "已经发送过邮件，请等待 %s 秒再重试"),
	RESOURCE_FILE_NOT_FOUND(4, "资源 %s 不存在"),
	READ_RESOURCE_FILE_FAILED(5, "读取资源 %s 失败"),
	;

	private int code;
	private String desc;

	IBRepoResp(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public int getCode() { return code; }

	@Override
	public String getDesc() { return desc; }

	public static IBRepoResp findByCode(int code) {
		for (IBRepoResp response : IBRepoResp.values()) {
			if (response.code == code) {
				return response;
			}
		}
		return null;
	}

	public static IBRepoResp of(int code) {
		IBRepoResp response = findByCode(code);
		if (response == null) {
			throw new IllegalArgumentException(String.format("%s 不是合法的 ResponseCode", code));
		}
		return response;
	}

}
