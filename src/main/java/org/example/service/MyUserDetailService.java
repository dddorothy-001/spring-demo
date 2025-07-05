package org.example.service;

import org.example.config.LoginUser;
import org.example.mapper.SysPermissionMapper;
import org.example.mapper.SysUserMapper;
import org.example.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysPermissionMapper permissionMapper;

//    @Cacheable(value = "username", key = "#username")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("正被查询");
        SysUser user = userMapper.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("用户不存在");

        List<String> permissions = permissionMapper.findPermissionsByUserId(user.getId());
        return new LoginUser(user, permissions);
//        return null;
    }
}

