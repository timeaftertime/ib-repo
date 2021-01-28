package cn.milai.ibrepo;

import cn.milai.common.api.RespCode;

/**
 * 返回状态枚举 
 * create 2020.01.27
 * 
 * @author milai
 */
public enum IBRepoResp implements RespCode {

	UNKNOWN_ERROR("UNKNOWN_ERROR", "系统异常"),
	PARAM_INVALID("PARAM_INVALID", "%s"),
	EMAIL_CODE_SENT("EMAIL_CODE_SENT", "已经发送过邮件，请等待 %s 秒再重试"),
	RESOURCE_FILE_NOT_FOUND("RESOURCE_FILE_NOT_FOUND", "资源 %s 不存在"),
	READ_RESOURCE_FILE_FAILED("READ_RESOURCE_FILE_FAILED", "读取资源 %s 失败"),
	;

	private String code;
	private String desc;

	IBRepoResp(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getDesc() {
		return desc;
	}

	public static IBRepoResp findByCode(String code) {
		for (IBRepoResp response : IBRepoResp.values()) {
			if (response.code.equals(code)) {
				return response;
			}
		}
		return null;
	}

	public static IBRepoResp of(String code) {
		IBRepoResp response = findByCode(code);
		if (response == null) {
			throw new IllegalArgumentException(String.format("%s 不是合法的 ResponseCode", code));
		}
		return response;
	}

}
