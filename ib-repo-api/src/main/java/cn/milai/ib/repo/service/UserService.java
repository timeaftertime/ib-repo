package cn.milai.ib.repo.service;

import cn.milai.common.api.Resp;
import cn.milai.ib.repo.service.dto.UserLoginDTO;
import cn.milai.ib.repo.service.dto.UserRegisterDTO;

/**
 * 用户相关接口 Service
 * 2020.01.28
 * @author milai
 */
public interface UserService {

	/**
	 * 登录，若成功，返回 token
	 * @param req
	 * @return
	 */
	Resp<String> login(UserLoginDTO req);

	/**
	 * 注册，若成功，返回登录后的 token
	 * @param req
	 * @return
	 */
	Resp<String> register(UserRegisterDTO req);

	/**
	 * 向 email 发送带有验证码的邮件
	 * @param email
	 * @return
	 */
	Resp<Void> sendValidateEmail(String email);
}
