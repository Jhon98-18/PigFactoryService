package com.pj.littlepig.dao;

import com.pj.littlepig.pojo.Role;
import com.pj.littlepig.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    @Select("SELECT * FROM user_role WHERE userId = #{userId}")
    List<UserRole> listByUserId(Integer userId);
}