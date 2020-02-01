package cn.milai.ib.repo.service;

import cn.milai.ib.repo.model.Response;
import cn.milai.ib.repo.service.req.UserLoginRequest;
import cn.milai.ib.repo.service.req.UserRegisterRequest;

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
	Response<String> login(UserLoginRequest req);

	/**
	 * 注册，若成功，返回登录后的 token
	 * @param req
	 * @return
	 */
	Response<String> register(UserRegisterRequest req);

	/**
	 * 向 email 发送带有验证码的邮件
	 * @param email
	 * @return
	 */
	Response<Void> sendValidateEmail(String email);
}
