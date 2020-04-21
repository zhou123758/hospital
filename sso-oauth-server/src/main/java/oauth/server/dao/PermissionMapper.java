package oauth.server.dao;

import oauth.server.pojo.TbPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {
    List<TbPermission> getByUserid(Long uid);
}
