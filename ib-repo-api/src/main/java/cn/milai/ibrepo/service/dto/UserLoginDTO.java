package cn.milai.ibrepo.service.dto;

import lombok.Data;

/**
 * 用户登录请求数据模型
 * 2020.01.28
 * @author milai
 */
@Data
public class UserLoginDTO {

	private String username;

	private String email;

	private String password;
}
