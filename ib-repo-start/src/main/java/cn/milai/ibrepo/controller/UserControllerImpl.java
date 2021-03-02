package cn.milai.ibrepo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.milai.common.api.Mappers;
import cn.milai.common.api.Resp;
import cn.milai.ibrepo.conf.CookieKey;
import cn.milai.ibrepo.controller.vo.UserVO;
import cn.milai.ibrepo.controller.vo.UserVO.LoginGroup;
import cn.milai.ibrepo.controller.vo.UserVO.RegisterGroup;
import cn.milai.ibrepo.service.UserService;
import cn.milai.ibrepo.service.dto.UserLoginDTO;
import cn.milai.ibrepo.service.dto.UserRegisterDTO;
import cn.milai.ibrepo.util.ValidUtil;

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

	@Override
	@PostMapping(value = "/login")
	public Resp<Void> login(@Validated(LoginGroup.class) UserVO user, HttpServletResponse response) {
		ValidUtil.email(user.getEmail(), false);
		Resp<String> result = userService.login(Mappers.map(user, UserLoginDTO.class));
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
		Resp<String> result = userService.register(Mappers.map(user, UserRegisterDTO.class));
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
