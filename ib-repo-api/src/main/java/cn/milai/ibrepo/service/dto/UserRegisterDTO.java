package cn.milai.ibrepo.service.dto;

/**
 * 用户注册请求数据模型
 * 2020.01.28
 * @author milai
 */
public class UserRegisterDTO {

	private String username;

	private String email;

	private String password;

	private String validateCode;

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getValidateCode() { return validateCode; }

	public void setValidateCode(String validateCode) { this.validateCode = validateCode; }

}
