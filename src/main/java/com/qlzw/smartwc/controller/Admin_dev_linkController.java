package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Admin_dev_link;
import com.qlzw.smartwc.service.Admin_dev_linkService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/admin_dev_link")
@RestController
public class Admin_dev_linkController {

    @Autowired
    private Admin_dev_linkService admin_dev_linkService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Admin_dev_link admin_dev_link) {
        
        HashMap map = admin_dev_linkService.list(page,admin_dev_link);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = admin_dev_linkService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = admin_dev_linkService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Admin_dev_link admin_dev_link) {
        
        HashMap map = admin_dev_linkService.store(admin_dev_link);
        
        return map;
    }
}

