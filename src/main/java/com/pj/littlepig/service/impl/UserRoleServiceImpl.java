package com.pj.littlepig.service.impl;

import com.pj.littlepig.dao.RoleMapper;
import com.pj.littlepig.dao.UserRoleMapper;
import com.pj.littlepig.pojo.Role;
import com.pj.littlepig.pojo.UserRole;
import com.pj.littlepig.service.RoleService;
import com.pj.littlepig.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public List<UserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
