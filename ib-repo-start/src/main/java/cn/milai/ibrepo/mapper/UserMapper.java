package cn.milai.ibrepo.mapper;

import org.mapstruct.Mapper;

import cn.milai.ibrepo.controller.vo.UserVO;
import cn.milai.ibrepo.dao.po.UserPO;
import cn.milai.ibrepo.service.dto.UserLoginDTO;
import cn.milai.ibrepo.service.dto.UserRegisterDTO;

/**
 * User 数据模型转换器
 * @author milai
 * @date 2020.01.31
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

	UserLoginDTO toLogin(UserVO vo);

	UserRegisterDTO toRegister(UserVO vo);

	UserPO toDO(UserRegisterDTO req);

}
