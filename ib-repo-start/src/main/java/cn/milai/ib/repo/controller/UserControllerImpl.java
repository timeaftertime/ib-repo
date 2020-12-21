package cn.milai.ib.repo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.milai.common.api.Resp;
import cn.milai.ib.repo.conf.CookieKey;
import cn.milai.ib.repo.controller.vo.UserVO;
import cn.milai.ib.repo.controller.vo.UserVO.LoginGroup;
import cn.milai.ib.repo.controller.vo.UserVO.RegisterGroup;
import cn.milai.ib.repo.mapper.UserMapper;
import cn.milai.ib.repo.service.UserService;
import cn.milai.ib.repo.util.ValidUtil;

/**
 * UserController 默认实现 
 * @date 2020.01.27
 * @author milai
 */
@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;

	@Override
	@PostMapping(value = "/login")
	public Resp<Void> login(@Validated(LoginGroup.class) UserVO user, HttpServletResponse response) {
		ValidUtil.email(user.getEmail(), false);
		Resp<String> result = userService.login(userMapper.toLogin(user));
		if (!result.isSuccess()) {
			return Resp.fail(result);
		}
		String token = result.getData();
		response.addCookie(new Cookie(CookieKey.TOKEN, token));
		return Resp.success();
	}

	@Override
	@PostMapping(value = "/register")
	public Resp<Void> register(@Validated(RegisterGroup.class) UserVO user, HttpServletResponse response) {
		ValidUtil.email(user.getEmail(), true);
		Resp<String> result = userService.register(userMapper.toRegister(user));
		if (!result.isSuccess()) {
			return Resp.fail(result);
		}
		String token = result.getData();
		response.addCookie(new Cookie(CookieKey.TOKEN, token));
		return Resp.success();
	}

	@Override
	@PostMapping(value = "/sendValidateCode")
	public Resp<Void> sendValidateCode(String email) {
		ValidUtil.email(email);
		return userService.sendValidateEmail(email);
	}

}
