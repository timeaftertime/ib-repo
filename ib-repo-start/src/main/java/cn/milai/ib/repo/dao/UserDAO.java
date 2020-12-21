package cn.milai.ib.repo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import cn.milai.ib.repo.dao.po.UserPO;

@Mapper
public interface UserDAO {

	String TABLE = " e_user ";

	@Select({ "select * from", TABLE, "where id = #{id}" })
	UserPO selectById(long id);

	@Select({ "select * from", TABLE, "where username = #{username}" })
	UserPO selectByUsername(String username);

	@Select({ "select * from", TABLE, "where email = #{email}" })
	UserPO selectByEmail(String email);

	@Insert({ "insert into", TABLE, "(username, password, email) values (#{username}, #{password}, #{email})" })
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void insertUser(UserPO user);

	@Select({ "select count(*) from", TABLE, "where username = #{username} limit 1" })
	boolean existsUsername(String username);

	@Select({ "select count(*) from", TABLE, "where email = #{email} limit 1" })
	boolean existsEmail(String email);

}
