package oauth.server.service;


import oauth.server.dao.PermissionMapper;
import oauth.server.dao.UserMapper;
import oauth.server.pojo.TbPermission;
import oauth.server.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapperService userMapperService;

    @Autowired
    PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = userMapperService.loadUserByUsername(s);
        if(tbUser == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        //获取用户权限
        List<TbPermission> permissions =permissionService.getByUserid(tbUser.getId());
        //设置用户权限
        permissions.forEach(permission -> {
            authorities.add(new SimpleGrantedAuthority(permission.getEname()));
        });
//        tbUser.setTbRoles(userMapperService.getTbUserTbRoleByUid(tbUser.getId()));
//        tbUser.getTbRoles().forEach(tbRole -> {
//            authorities.add(new SimpleGrantedAuthority(tbRole.getName()));
//        });
        //返回认证用户
        return new User(tbUser.getUsername(),tbUser.getPassword(),authorities);
    }
}
