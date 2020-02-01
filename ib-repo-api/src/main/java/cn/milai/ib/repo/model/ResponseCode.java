package cn.milai.ib.repo.model;

/**
 * Controller 返回码枚举 
 * create 2020.01.27
 * 
 * @author milai
 */
public enum ResponseCode {

	SUCCESS("SUCCESS", ""),
	UNKNOWN_ERROR("UNKNOWN_ERROR", ""),
	PARAM_INVALID("PARAM_INVALID", "%s"),
	EMAIL_CODE_SENT("EMAIL_CODE_SENT", "已经发送过邮件，请等待 %s 秒再重试"),
	RESOURCE_FILE_NOT_FOUND("RESOURCE_FILE_NOT_FOUND", "资源 %s 不存在"),
	READ_RESOURCE_FILE_FAILED("READ_RESOURCE_FILE_FAILED", "读取资源 %s 失败"),
	;

	private String code;
	private String desc;

	ResponseCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public static ResponseCode findByCode(String code) {
		for (ResponseCode response : ResponseCode.values()) {
			if (response.code.equals(code)) {
				return response;
			}
		}
		return null;
	}

	public static ResponseCode of(String code) {
		ResponseCode response = findByCode(code);
		if (response == null) {
			throw new IllegalArgumentException(String.format("%s 不是合法的 ResponseCode", code));
		}
		return response;
	}

}
