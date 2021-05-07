package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Mp_user;
import com.qlzw.smartwc.service.Mp_userService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/mp_user")
@RestController
public class Mp_userController {

    @Autowired
    private Mp_userService mp_userService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Mp_user mp_user) {
        
        HashMap map = mp_userService.list(page,mp_user);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = mp_userService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = mp_userService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Mp_user mp_user) {
        
        HashMap map = mp_userService.store(mp_user);
        
        return map;
    }
}

