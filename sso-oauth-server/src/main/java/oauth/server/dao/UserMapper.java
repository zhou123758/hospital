package oauth.server.dao;

import oauth.server.pojo.TbRole;
import oauth.server.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    TbUser loadUserByUsername(String username);

    List<TbRole> getTbUserTbRoleByUid(Long id);
}
