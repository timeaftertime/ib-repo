package cn.milai.ib.repo.service.req;

import lombok.Data;

/**
 * 用户登录请求数据模型
 * 2020.01.28
 * @author milai
 */
@Data
public class UserLoginRequest {

	private String username;

	private String email;

	private String password;
}
