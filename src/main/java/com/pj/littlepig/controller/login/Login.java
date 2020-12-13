package com.pj.littlepig.controller.login;

import com.pj.littlepig.pojo.SysUser;
import com.pj.littlepig.service.UserRoleService;
import com.pj.littlepig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
public class Login {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public void login(@RequestParam String userName, @RequestParam String passWord) {
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userName, passWord);
        // 验证
        Authentication auth = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @PostMapping("/Register")
    public void Register(@RequestBody SysUser user) {
        if (user != null) {
            userService.insert(user);
        }
    }
}
