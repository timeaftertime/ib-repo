package cn.milai.ibrepo.service.dto;

import lombok.Data;

/**
 * 用户注册请求数据模型
 * 2020.01.28
 * @author milai
 */
@Data
public class UserRegisterDTO {

	private String username;

	private String email;

	private String password;

	private String validateCode;
}
