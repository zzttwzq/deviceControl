package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev;
import com.qlzw.smartwc.service.DevService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev")
@RestController
public class DevController {

    @Autowired
    private DevService devService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev dev) {
        
        HashMap map = devService.list(page,dev);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = devService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = devService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev dev) {
        
        HashMap map = devService.store(dev);
        
        return map;
    }
}

