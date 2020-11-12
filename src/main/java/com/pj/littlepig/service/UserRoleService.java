package com.pj.littlepig.service;


import com.pj.littlepig.pojo.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> listByUserId(Integer userId);

}
