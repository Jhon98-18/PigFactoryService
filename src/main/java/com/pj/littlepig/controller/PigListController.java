package com.pj.littlepig.controller;

import com.pj.littlepig.Vo.PigPaginationInfo;
import com.pj.littlepig.pojo.Pig;
import com.pj.littlepig.pojo.Role;
import com.pj.littlepig.pojo.SysUser;
import com.pj.littlepig.pojo.UserRole;
import com.pj.littlepig.response.ResponseEntity;
import com.pj.littlepig.response.ResponseStatus;
import com.pj.littlepig.service.PigListService;
import com.pj.littlepig.service.RoleService;
import com.pj.littlepig.service.UserRoleService;
import com.pj.littlepig.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pj.littlepig.response.ResponseStatus.OK;
import static com.pj.littlepig.response.ResponseStatus.WRONG;

@CrossOrigin
@RestController
@RequestMapping("/pig")
public class PigListController {
    @Autowired
    private PigListService pigListService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/getPigList")
    public ResponseEntity getPigListByFactoryId(@RequestParam(value = "factoryId",required = false) String factoryId) {
        List<Pig> pig = pigListService.getPigListByFactory(factoryId);
        return new ResponseEntity(pig);
    }

    @GetMapping("/getAllPigList")
    public ResponseEntity getAllPigList() {
        List<Pig> pig = pigListService.getAllPigList();
        return new ResponseEntity(pig);
    }

    @PostMapping("/getPagePigList")
    public ResponseEntity getPagePigList(@RequestBody PigPaginationInfo paginationInfo) {
        List<Pig> pig = pigListService.getPagePigList(paginationInfo);
        return new ResponseEntity(pig);
    }

    //这个异常是用来处理那些没用控制住的异常，如IndexOver。。。
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity error(Exception e) {
        e.printStackTrace();
        return new ResponseEntity(WRONG);
    }
}

