package com.pj.littlepig.dao;

import com.pj.littlepig.Vo.PigPaginationInfo;
import com.pj.littlepig.pojo.Pig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pig record);

    int insertSelective(Pig record);

    Pig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pig record);

    int updateByPrimaryKey(Pig record);

    /*自定义*/
    List<Pig> getPigListByFactory(Integer factoryId);

    List<Pig> getPagePigList(PigPaginationInfo paginationInfo);

    List<Pig> getAllPigList();
}
