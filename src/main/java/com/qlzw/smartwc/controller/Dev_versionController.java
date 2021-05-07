package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_version;
import com.qlzw.smartwc.service.Dev_versionService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_version")
@RestController
public class Dev_versionController {

    @Autowired
    private Dev_versionService dev_versionService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_version dev_version) {
        
        HashMap map = dev_versionService.list(page,dev_version);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_versionService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_versionService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_version dev_version) {
        
        HashMap map = dev_versionService.store(dev_version);
        
        return map;
    }
}

