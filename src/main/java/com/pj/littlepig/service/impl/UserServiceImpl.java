package com.pj.littlepig.service.impl;

import com.pj.littlepig.dao.UserMapper;
import com.pj.littlepig.pojo.SysUser;
import com.pj.littlepig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

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
}
