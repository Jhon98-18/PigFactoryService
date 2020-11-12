package com.pj.littlepig.service.impl;

import com.pj.littlepig.dao.RoleMapper;
import com.pj.littlepig.pojo.Role;
import com.pj.littlepig.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Role selectById(Integer id) {
        return roleMapper.selectById(id);
    }
}
