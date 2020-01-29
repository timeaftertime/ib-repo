package cn.milai.ib.repo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import cn.milai.ib.repo.dao.model.UserDO;

@Mapper
public interface UserDAO {

	String TABLE = " e_user ";

	@Select({ "select * from", TABLE, "where id = #{id}" })
	UserDO selectById(long id);

	@Insert({ "insert info", TABLE, "(username, password, email)", "values", "(#{username}, #{password}, #{email})" })
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void insertUser(UserDO user);
}
