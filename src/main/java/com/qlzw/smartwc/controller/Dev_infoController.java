package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_info;
import com.qlzw.smartwc.service.Dev_infoService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_info")
@RestController
public class Dev_infoController {

    @Autowired
    private Dev_infoService dev_infoService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_info dev_info) {
        
        HashMap map = dev_infoService.list(page,dev_info);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_infoService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_infoService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_info dev_info) {
        
        HashMap map = dev_infoService.store(dev_info);
        
        return map;
    }
}

