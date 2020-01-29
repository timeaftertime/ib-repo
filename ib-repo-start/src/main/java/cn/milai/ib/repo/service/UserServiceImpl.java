package cn.milai.ib.repo.service;

import org.springframework.stereotype.Service;

import cn.milai.ib.repo.entity.Response;
import cn.milai.ib.repo.service.req.UserLoginRequest;
import cn.milai.ib.repo.service.req.UserRegisterRequest;

/**
 * UserService 默认实现 2020.01.28
 * 
 * @author milai
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public Response<Void> login(UserLoginRequest req) {
		System.out.println(req);
		return Response.success();
	}

	@Override
	public Response<Void> register(UserRegisterRequest req) {
		System.out.println(req);
		return Response.success();
	}

}
