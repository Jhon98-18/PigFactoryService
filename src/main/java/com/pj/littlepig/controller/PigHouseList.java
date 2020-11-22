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
    public ResponseEntity getPigHouseListByHouseId(@RequestParam(value = "houseId",required = false) String houseId) {
        List<PigHouse> pigHouseListByHouseId = pigHouseListService.getPigHouseListByHouseId(houseId);
        return new ResponseEntity(pigHouseListByHouseId);
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


}
