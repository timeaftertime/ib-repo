package cn.milai.ib.repo.entity.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * 用户视图模型
 * 2020.01.28
 * @author milai
 */
@Data
public class UserVO {

	private Long id;

	@NotNull(groups = RegisterGroup.class, message = "用户名不能为空")
	@Pattern(groups = { LoginGroup.class, RegisterGroup.class },
		regexp = "[0-9a-zA-Z_]{8,32}",
		message = "用户名为8~32位的字母数字或下划线")
	private String username;

	@NotNull(groups = RegisterGroup.class, message = "密码不能为空")
	@Pattern(groups = { LoginGroup.class, RegisterGroup.class },
		regexp = "[0-9a-zA-Z`~!@#$%^&*\\(\\)-=_+,\\./<>\\?\\[\\]\\{\\}|\\\\:\\\'\\\"]{8,32}",
		message = "密码为8~32位字母数字和普通标点符号")
	private String password;

	@NotNull(groups = RegisterGroup.class)
	private String email;

	public interface LoginGroup {

	}

	public interface RegisterGroup {

	}
}
