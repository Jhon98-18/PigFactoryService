package com.pj.littlepig.service.impl;

import com.pj.littlepig.Vo.PigHousePaginationInfo;
import com.pj.littlepig.dao.PigHouseMapper;
import com.pj.littlepig.dao.PigMapper;
import com.pj.littlepig.pojo.Pig;
import com.pj.littlepig.pojo.PigHouse;
import com.pj.littlepig.service.PigHouseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PigHouseListServiceImpl implements PigHouseListService {

    @Autowired
    private PigHouseMapper pigHouseMapper;
    @Override
    public List<PigHouse> getPigHouseListByHouseId(String houseId) {
        List<PigHouse> pigHouseListByHouseId = pigHouseMapper.getPigHouseListByHouseId(Integer.parseInt(houseId));
        return pigHouseListByHouseId;
    }

    @Override
    public List<PigHouse> getPagePigHouseList(PigHousePaginationInfo pigHousePaginationInfo) {
        List<PigHouse> pagePigHouseList = pigHouseMapper.getPagePigHouseList(pigHousePaginationInfo);
        return pagePigHouseList;
    }

    @Override
    public List<PigHouse> getAllPigHouseList() {
        List<PigHouse> pagePigHouseList = pigHouseMapper.getAllPigHouseList();
        return pagePigHouseList;
    }
}
