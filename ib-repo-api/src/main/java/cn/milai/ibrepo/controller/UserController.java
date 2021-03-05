package cn.milai.ibrepo.controller;

import javax.servlet.http.HttpServletResponse;

import cn.milai.common.decoupling.Resp;
import cn.milai.ibrepo.controller.vo.UserVO;

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
	Resp<Void> login(UserVO user, HttpServletResponse response);

	/**
	 * 注册
	 * @param user
	 * @param response
	 * @return
	 */
	Resp<Void> register(UserVO user, HttpServletResponse response);

	/**
	 * 发送邮箱验证码
	 * @param email
	 * @return
	 */
	Resp<Void> sendValidateCode(String email);
}
