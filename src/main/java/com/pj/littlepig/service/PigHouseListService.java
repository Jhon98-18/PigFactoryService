package com.pj.littlepig.service;

import com.pj.littlepig.Vo.PigHousePaginationInfo;
import com.pj.littlepig.pojo.PigHouse;

import java.util.List;

public interface PigHouseListService {
    List<PigHouse> getPigHouseListByFactory(String factoryId);

    List<PigHouse> getPagePigHouseList(PigHousePaginationInfo pigHousePaginationInfo);

    List<PigHouse> getAllPigHouseList();
}
