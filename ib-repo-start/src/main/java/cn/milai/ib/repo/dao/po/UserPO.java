package cn.milai.ib.repo.dao.po;

import lombok.Data;

/**
 * 用户模型类
 * 2020.01.28
 * @author milai
 */
@Data
public class UserPO {

	private long id;

	private String username;

	private String password;

	private String email;

	private String createTime;

}
