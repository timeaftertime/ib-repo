package cn.milai.ib.repo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.milai.ib.repo.entity.Response;
import cn.milai.ib.repo.entity.vo.UserVO;
import cn.milai.ib.repo.entity.vo.UserVO.LoginGroup;
import cn.milai.ib.repo.entity.vo.UserVO.RegisterGroup;
import cn.milai.ib.repo.mapper.UserMapper;
import cn.milai.ib.repo.service.UserService;

/**
 * UserController 默认实现 2020.01.27
 * 
 * @author milai
 */
@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;

	@PostMapping(value = "/login")
	@Override
	public Response<Void> login(@Validated(LoginGroup.class) UserVO user) {
		return userService.login(userMapper.toLogin(user));
	}

	@PostMapping(value = "/register")
	@Override
	public Response<Void> register(@Validated(RegisterGroup.class) UserVO user) {
		return userService.register(userMapper.toRegister(user));
	}

}
