package oauth.server.service;

import oauth.server.dao.UserMapper;
import oauth.server.pojo.TbRole;
import oauth.server.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapperServiceImpl implements UserMapperService{
    @Autowired
    UserMapper userMapper;
    @Override
    public TbUser loadUserByUsername(String username) {
        return userMapper.loadUserByUsername(username);
    }

    @Override
    public List<TbRole> getTbUserTbRoleByUid(Long id) {
        return userMapper.getTbUserTbRoleByUid(id);
    }
}
