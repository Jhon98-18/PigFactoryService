package com.pj.littlepig.service;

import com.pj.littlepig.pojo.Role;
import com.pj.littlepig.pojo.SysUser;
import com.pj.littlepig.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList();
        SysUser user = userService.selectByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<UserRole> userRoles = userRoleService.listByUserId(user.getId());
        for (UserRole userRole : userRoles) {
            Role role = roleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        /*User user1 = new User(user.getUserName(),user.getPassWord(),authorities);

        SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
        TestingAuthenticationToken testUser = new TestingAuthenticationToken("username", "password", "role");
        emptyContext.setAuthentication(testUser);
        SecurityContextHolder.setContext(emptyContext);*/
        //UserDetails build = userBuilder.username(user.getUserName()).password(user.getPassWord()).authorities(authorities).build();
        return new User(user.getUserName(),user.getPassWord(),authorities);
    }
}
