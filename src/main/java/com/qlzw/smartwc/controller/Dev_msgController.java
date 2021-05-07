package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_msg;
import com.qlzw.smartwc.service.Dev_msgService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_msg")
@RestController
public class Dev_msgController {

    @Autowired
    private Dev_msgService dev_msgService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_msg dev_msg) {
        
        HashMap map = dev_msgService.list(page,dev_msg);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_msgService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_msgService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_msg dev_msg) {
        
        HashMap map = dev_msgService.store(dev_msg);
        
        return map;
    }
}

