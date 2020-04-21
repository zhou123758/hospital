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


@Data
@Setter
@Getter
@Accessors(chain = true)
public class TbPermission  {


	/** 主键ID */

	private Long id;

	/** 用户ID */
	private Long parentId;

	/** 权限名字 */
	private String name;

	/** 权限名字 */
	private String ename;

	/** 请求路径 */
	private String url;

	/** 描述 */
	private String description;

	/** 创建时间 */
	private Date createTime;

	/** 更新时间 */
	private Date updateTime;

}
