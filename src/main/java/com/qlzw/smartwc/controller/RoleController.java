package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Role;
import com.qlzw.smartwc.service.RoleService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Role role) {
        
        HashMap map = roleService.list(page,role);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = roleService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = roleService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Role role) {
        
        HashMap map = roleService.store(role);
        
        return map;
    }
}

