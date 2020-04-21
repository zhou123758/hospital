package oauth.server.pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Description  
 * @Author  Henry
 * @Date 2020-04-09 
 */
@Setter
@Getter
@Data
@Accessors(chain = true)
public class TbRole  {


	/** 主键ID */

	private Long id;

	/** 父类ID */
	private Long parentId;

	/** 角色名字 */
	private String name;

	/** 角色名字 */
	private String ename;

	/** 描述 */
	private String description;

	/** 创建时间 */
	private Date createTime;

	/** 更新时间 */
	private Date updateTime;

}
