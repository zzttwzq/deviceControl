package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_update_msg;
import com.qlzw.smartwc.service.Dev_update_msgService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_update_msg")
@RestController
public class Dev_update_msgController {

    @Autowired
    private Dev_update_msgService dev_update_msgService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_update_msg dev_update_msg) {
        
        HashMap map = dev_update_msgService.list(page,dev_update_msg);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_update_msgService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_update_msgService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_update_msg dev_update_msg) {
        
        HashMap map = dev_update_msgService.store(dev_update_msg);
        
        return map;
    }
}

