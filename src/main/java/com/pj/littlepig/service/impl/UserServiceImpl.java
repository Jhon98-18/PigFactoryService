package com.pj.littlepig.service.impl;

import com.pj.littlepig.dao.UserMapper;
import com.pj.littlepig.pojo.SysUser;
import com.pj.littlepig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public SysUser selectByName(String userName) {
        return userMapper.selectByName(userName);
    }

    @Override
    public void insert(SysUser user) {
        boolean isPass = preInsertUser(user);
        if (isPass) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
            int insert = userMapper.insert(user);
        }
    }

    private boolean preInsertUser(SysUser user) {
        if (user == null) {
            throw new RuntimeException("用户不能为空");
        }

        if (user.getPassWord() == null) {
            throw new RuntimeException("密码为空!!");
        }
        SysUser sysUser = userMapper.selectByName(user.getUserName());
        if (sysUser != null) {
            throw new RuntimeException("用户重复！");
        }
        return true;
    }
}
