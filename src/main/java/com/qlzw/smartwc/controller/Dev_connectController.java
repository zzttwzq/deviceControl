package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_connect;
import com.qlzw.smartwc.service.Dev_connectService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_connect")
@RestController
public class Dev_connectController {

    @Autowired
    private Dev_connectService dev_connectService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_connect dev_connect) {
        
        HashMap map = dev_connectService.list(page,dev_connect);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_connectService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_connectService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_connect dev_connect) {
        
        HashMap map = dev_connectService.store(dev_connect);
        
        return map;
    }
}

