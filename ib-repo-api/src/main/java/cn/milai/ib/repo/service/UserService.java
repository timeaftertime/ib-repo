package cn.milai.ib.repo.service;

import cn.milai.ib.repo.entity.Response;
import cn.milai.ib.repo.service.req.UserLoginRequest;
import cn.milai.ib.repo.service.req.UserRegisterRequest;

/**
 * 用户相关接口 Service
 * 2020.01.28
 * @author milai
 */
public interface UserService {

	/**
	 * 登录
	 * @param req
	 * @return
	 */
	Response<Void> login(UserLoginRequest req);

	/**
	 * 注册
	 * @param req
	 * @return
	 */
	Response<Void> register(UserRegisterRequest req);
}
