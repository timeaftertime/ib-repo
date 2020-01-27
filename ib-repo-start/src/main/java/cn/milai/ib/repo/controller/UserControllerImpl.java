package cn.milai.ib.repo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.milai.ib.repo.entity.Response;

/**
 * UserController 默认实现
 * 2020.01.27
 * @author milai
 */
@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

	@PostMapping("/login")
	@Override
	public Response<Void> login() {
		return null;
	}

}
