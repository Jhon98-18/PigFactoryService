package com.pj.littlepig.controller.login;

import com.pj.littlepig.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public class Login {
    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public void login(@RequestParam String userName, @RequestParam String passWord) {
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userName, passWord);
        // 验证
        Authentication auth = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
