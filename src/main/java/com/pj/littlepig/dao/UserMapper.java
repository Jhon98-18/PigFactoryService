package com.pj.littlepig.dao;

import com.pj.littlepig.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    @Select("SELECT * FROM user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM user WHERE userName = #{userName}")
    SysUser selectByName(String userName);

}
