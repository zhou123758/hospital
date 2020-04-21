package oauth.server.service;

import oauth.server.dao.PermissionMapper;
import oauth.server.pojo.TbPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public List<TbPermission> getByUserid(Long uid) {
        return permissionMapper.getByUserid(uid);
    }
}
