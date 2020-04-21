package oauth.resource.pojo;

import java.util.Date;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-09 
 */


public class TbUser  {


	/** 主键ID */

	private Long id;

	/** 用户名 */
	private String username;

	/** 密码 */
	private String password;

	/** 性别（1男 2女） */
	private Long gender;

	/** 邮箱 */
	private String email;

	/** 用户创建时间 */
	private Date createTime;

	/** 更新时间 */
	private Date updateTime;

	/** 是否删除（1删除0未删除） */
	private Long removed;

	@Override
	public String toString() {
		return "TbUser{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", gender=" + gender +
				", email='" + email + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", removed=" + removed +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getGender() {
		return gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getRemoved() {
		return removed;
	}

	public void setRemoved(Long removed) {
		this.removed = removed;
	}
}
