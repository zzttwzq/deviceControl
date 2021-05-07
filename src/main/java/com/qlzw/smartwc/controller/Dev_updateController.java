package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_update;
import com.qlzw.smartwc.service.Dev_updateService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_update")
@RestController
public class Dev_updateController {

    @Autowired
    private Dev_updateService dev_updateService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_update dev_update) {
        
        HashMap map = dev_updateService.list(page,dev_update);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_updateService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_updateService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_update dev_update) {
        
        HashMap map = dev_updateService.store(dev_update);
        
        return map;
    }
}

