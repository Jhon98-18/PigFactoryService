package com.pj.littlepig.dao;

import com.pj.littlepig.pojo.Factory;

public interface FactoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Factory record);

    int insertSelective(Factory record);

    Factory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Factory record);

    int updateByPrimaryKey(Factory record);
}