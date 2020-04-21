package oauth.server.pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-09 
 */

@Setter
@Getter
@Data
@Accessors(chain = true)
public class TbUser implements UserDetails {


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

	private List<TbRole> tbRoles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (TbRole tbRole : tbRoles){
			authorities.add(new SimpleGrantedAuthority(tbRole.getName()));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
