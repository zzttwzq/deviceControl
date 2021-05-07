package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Admin_link;
import com.qlzw.smartwc.service.Admin_linkService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/admin_link")
@RestController
public class Admin_linkController {

    @Autowired
    private Admin_linkService admin_linkService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Admin_link admin_link) {
        
        HashMap map = admin_linkService.list(page,admin_link);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = admin_linkService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = admin_linkService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Admin_link admin_link) {
        
        HashMap map = admin_linkService.store(admin_link);
        
        return map;
    }
}

