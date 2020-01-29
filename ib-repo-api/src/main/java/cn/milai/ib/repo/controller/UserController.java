package cn.milai.ib.repo.controller;

import cn.milai.ib.repo.entity.Response;
import cn.milai.ib.repo.entity.vo.UserVO;

/**
 * 用户相关前端接口
 * @date 2020.01.27
 * @author milai
 */
public interface UserController {

	Response<Void> login(UserVO user);

	Response<Void> register(UserVO user);
}
