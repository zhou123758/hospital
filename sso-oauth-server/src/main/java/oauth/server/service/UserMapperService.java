package oauth.server.service;

import oauth.server.pojo.TbRole;
import oauth.server.pojo.TbUser;

import java.util.List;

public interface UserMapperService {
    TbUser loadUserByUsername(String username);

    List<TbRole> getTbUserTbRoleByUid(Long id);
}
