package cn.milai.ibrepo.controller.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 用户视图模型
 * 2020.01.28
 * @author milai
 */
public class UserVO {

	private Long id;

	@NotNull(groups = RegisterGroup.class, message = "用户名不能为空")
	@Pattern(
		groups = { LoginGroup.class, RegisterGroup.class },
		regexp = "[0-9a-zA-Z_]{6,32}",
		message = "用户名为长度 6~32 的字母数字或下划线"
	)
	private String username;

	@NotNull(groups = RegisterGroup.class, message = "密码不能为空")
	@Pattern(
		groups = { LoginGroup.class, RegisterGroup.class },
		regexp = "[0-9A-Z]{64}",
		message = "加密后的密码为长度 64 的大写字母和数字"
	)
	private String password;

	private String email;

	@NotEmpty(groups = RegisterGroup.class, message = "邮箱验证码不能为空")
	private String validateCode;

	public interface LoginGroup {

	}

	public interface RegisterGroup {

	}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getValidateCode() { return validateCode; }

	public void setValidateCode(String validateCode) { this.validateCode = validateCode; }

}
