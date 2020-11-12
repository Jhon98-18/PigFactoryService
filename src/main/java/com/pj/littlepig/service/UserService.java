package com.pj.littlepig.service;


import com.pj.littlepig.pojo.SysUser;

public interface UserService {
    SysUser selectById(Integer id);
    SysUser selectByName(String userName);
}
