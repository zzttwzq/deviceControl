package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_action;
import com.qlzw.smartwc.service.Dev_actionService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_action")
@RestController
public class Dev_actionController {

    @Autowired
    private Dev_actionService dev_actionService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_action dev_action) {
        
        HashMap map = dev_actionService.list(page,dev_action);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_actionService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_actionService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_action dev_action) {
        
        HashMap map = dev_actionService.store(dev_action);
        
        return map;
    }
}

