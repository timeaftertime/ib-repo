package cn.milai.ib.repo.mapper;

import org.mapstruct.Mapper;

import cn.milai.ib.repo.model.vo.UserVO;
import cn.milai.ib.repo.service.req.UserLoginRequest;
import cn.milai.ib.repo.service.req.UserRegisterRequest;

/**
 * 用户业务数据模型转换器
 * @author milai
 * @date 2020.01.31
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

	UserLoginRequest toLogin(UserVO vo);

	UserRegisterRequest toRegister(UserVO vo);

}
