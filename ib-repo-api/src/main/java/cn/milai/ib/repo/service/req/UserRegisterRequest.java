package cn.milai.ib.repo.service.req;

import lombok.Data;

/**
 * 用户注册请求数据模型
 * 2020.01.28
 * @author milai
 */
@Data
public class UserRegisterRequest {

	private String username;

	private String email;

	private String password;

	private String validateCode;
}
