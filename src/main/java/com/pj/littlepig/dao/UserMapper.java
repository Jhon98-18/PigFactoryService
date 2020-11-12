package com.pj.littlepig.dao;

import com.pj.littlepig.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM user WHERE userName = #{userName}")
    SysUser selectByName(String userName);

}