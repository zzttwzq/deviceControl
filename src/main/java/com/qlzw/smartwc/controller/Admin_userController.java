package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Admin_user;
import com.qlzw.smartwc.service.Admin_userService;
import com.qlzw.smartwc.service.ResponseService;
import com.qlzw.smartwc.service.UserRoleService;
import com.qlzw.smartwc.utils.*;
import com.qlzw.smartwc.utils.Pager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/admin_user")
@RestController
public class Admin_userController {

    @Autowired
    private Admin_userService admin_userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private ResponseService responseService;

    // 获取用户列表 (带权限)
    @GetMapping("/getAdminList")
    public HashMap<String, Object> getAdminList(Pager page,@RequestHeader("token") String token) {

        if (token == null || token.isEmpty()) {

            HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_ERROR,"header token 不能为空！");

            return map;
        }

        if (userRoleService.isAdminRole(token)) {



            HashMap map = admin_userService.list(page,null);

            return map;
        }
        else {

            HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_ERROR,"您不是管理员权限，无权调用该接口！");

            return map;
        }
    }

    // 获取列表
    @GetMapping("/list")
    public HashMap<String, Object> list(Pager page,Admin_user admin_user) {
        
        HashMap map = admin_userService.list(page,admin_user);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = admin_userService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = admin_userService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Admin_user admin_user) {
        
        HashMap map = admin_userService.store(admin_user);
        
        return map;
    }
}

