package com.pj.littlepig.service.impl;

import com.pj.littlepig.Vo.PigPaginationInfo;
import com.pj.littlepig.dao.PigMapper;
import com.pj.littlepig.myexcept.MyExcept;
import com.pj.littlepig.pojo.Pig;
import com.pj.littlepig.service.PigListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class PigListServiceImpl implements PigListService {

    @Autowired
    private PigMapper pigMapper;

    public List<Pig> getPigListByFactory(String factoryId) {
        List<Pig> pigListByFactory = pigMapper.getPigListByFactory(Integer.parseInt(factoryId));
        return pigListByFactory;
        //return null;
    }

    @Override
    public List<Pig> getPagePigList(PigPaginationInfo paginationInfo) {
        List<Pig> pagePigList = pigMapper.getPagePigList(paginationInfo);
        return pagePigList;
    }

    @Override
    public List<Pig> getAllPigList() {
        List<Pig> pagePigList = pigMapper.getAllPigList();
        return pagePigList;
    }
}
