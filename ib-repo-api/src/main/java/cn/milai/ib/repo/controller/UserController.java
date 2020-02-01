package cn.milai.ib.repo.controller;

import javax.servlet.http.HttpServletResponse;

import cn.milai.ib.repo.model.Response;
import cn.milai.ib.repo.model.vo.UserVO;

/**
 * 用户相关前端接口
 * @date 2020.01.27
 * @author milai
 */
public interface UserController {

	/**
	 * 登录
	 * @param user
	 * @param response
	 * @return
	 */
	Response<Void> login(UserVO user, HttpServletResponse response);

	/**
	 * 注册
	 * @param user
	 * @param response
	 * @return
	 */
	Response<Void> register(UserVO user, HttpServletResponse response);

	/**
	 * 发送邮箱验证码
	 * @param email
	 * @return
	 */
	Response<Void> sendValidateCode(String email);
}
