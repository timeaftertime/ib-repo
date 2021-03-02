package cn.milai.ibrepo.dao.po;

/**
 * 用户模型类
 * 2020.01.28
 * @author milai
 */
public class UserPO {

	private long id;

	private String username;

	private String password;

	private String email;

	private String createTime;

	public long getId() { return id; }

	public void setId(long id) { this.id = id; }

	public String getUsername() { return username; }

	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getCreateTime() { return createTime; }

	public void setCreateTime(String createTime) { this.createTime = createTime; }

}
