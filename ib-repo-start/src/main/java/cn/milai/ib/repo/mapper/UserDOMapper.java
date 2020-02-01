package cn.milai.ib.repo.mapper;

import org.mapstruct.Mapper;

import cn.milai.ib.repo.dao.model.UserDO;
import cn.milai.ib.repo.service.req.UserRegisterRequest;

/**
 * 用户数据库模型转换器
 * @author milai
 * @date 2020.01.31
 */
@Mapper(componentModel = "spring")
public interface UserDOMapper {

	UserDO toDO(UserRegisterRequest req);
	
}
