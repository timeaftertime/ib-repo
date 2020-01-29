package cn.milai.ib.repo.mapper;

import org.mapstruct.Mapper;

import cn.milai.ib.repo.entity.vo.UserVO;
import cn.milai.ib.repo.service.req.UserLoginRequest;
import cn.milai.ib.repo.service.req.UserRegisterRequest;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserLoginRequest toLogin(UserVO vo);

	UserRegisterRequest toRegister(UserVO vo);

}
