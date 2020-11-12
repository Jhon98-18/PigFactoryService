package com.pj.littlepig.service;


import com.pj.littlepig.Vo.PigPaginationInfo;
import com.pj.littlepig.pojo.Pig;

import java.util.List;

public interface PigListService {
    List<Pig> getPigListByFactory(String factoryId);

    List<Pig> getPagePigList(PigPaginationInfo paginationInfo);

    List<Pig> getAllPigList();
}
