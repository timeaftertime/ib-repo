package cn.milai.ib.repo.entity;

/**
 * Controller 返回码枚举 
 * create 2020.01.27
 * 
 * @author milai
 */
public enum ResponseCode {

	SUCCESS("SUCCESS", null),
	UNKNOWN_ERROR("UNKNOWN_ERROR", null),
	PARAM_INVALID("PARAM_INVALID", "%s");
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

}
