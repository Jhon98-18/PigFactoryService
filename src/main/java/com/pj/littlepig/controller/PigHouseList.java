package com.pj.littlepig.controller;

import com.pj.littlepig.Vo.PigHousePaginationInfo;
import com.pj.littlepig.Vo.PigPaginationInfo;
import com.pj.littlepig.pojo.Pig;
import com.pj.littlepig.pojo.PigHouse;
import com.pj.littlepig.response.ResponseEntity;
import com.pj.littlepig.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pj.littlepig.response.ResponseStatus.WRONG;

@CrossOrigin
@RestController
@RequestMapping("/pighouse")
public class PigHouseList {
    @Autowired
    private PigHouseListService pigHouseListService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/getPigHouseList")
    public ResponseEntity getPigHouseListByFactoryId(@RequestParam(value = "factoryId",required = false) String factoryId) {
        List<PigHouse> pigHouseListByFactory = pigHouseListService.getPigHouseListByFactory(factoryId);
        return new ResponseEntity(pigHouseListByFactory);
    }

    @GetMapping("/getAllPigHouseList")
    public ResponseEntity getAllPigHouseList() {
        List<PigHouse> allPigHouseList = pigHouseListService.getAllPigHouseList();
        return new ResponseEntity(allPigHouseList);
    }

    @PostMapping("/getPagePigHouseList")
    public ResponseEntity getPagePigHouseList(@RequestBody PigHousePaginationInfo pigHousePaginationInfo) {
        List<PigHouse> pagePigHouseList = pigHouseListService.getPagePigHouseList(pigHousePaginationInfo);
        return new ResponseEntity(pagePigHouseList);
    }

    //这个异常是用来处理那些没用控制住的异常，如IndexOver。。。
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity error(Exception e) {
        e.printStackTrace();
        return new ResponseEntity(WRONG);
    }
}
