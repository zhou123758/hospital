package oauth.server.service;

import oauth.server.pojo.TbPermission;

import java.util.List;

public interface PermissionService {
    List<TbPermission> getByUserid(Long uid);
}
