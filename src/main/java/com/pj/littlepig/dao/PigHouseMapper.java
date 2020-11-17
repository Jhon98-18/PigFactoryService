package com.pj.littlepig.dao;

import com.pj.littlepig.Vo.PigHousePaginationInfo;
import com.pj.littlepig.pojo.Pig;
import com.pj.littlepig.pojo.PigHouse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PigHouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PigHouse record);

    int insertSelective(PigHouse record);

    PigHouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PigHouse record);

    int updateByPrimaryKey(PigHouse record);

    List<PigHouse> getPigHouseListByFactory(Integer factoryId);

    List<PigHouse> getPagePigHouseList(PigHousePaginationInfo pigHousePaginationInfo);

    List<PigHouse> getAllPigHouseList();
}
