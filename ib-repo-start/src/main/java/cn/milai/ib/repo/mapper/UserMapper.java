package cn.milai.ib.repo.mapper;

import org.mapstruct.Mapper;

import cn.milai.ib.repo.controller.vo.UserVO;
import cn.milai.ib.repo.dao.po.UserPO;
import cn.milai.ib.repo.service.dto.UserLoginDTO;
import cn.milai.ib.repo.service.dto.UserRegisterDTO;

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
