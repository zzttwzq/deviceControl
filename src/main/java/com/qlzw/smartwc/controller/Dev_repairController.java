package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_repair;
import com.qlzw.smartwc.service.Dev_repairService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_repair")
@RestController
public class Dev_repairController {

    @Autowired
    private Dev_repairService dev_repairService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_repair dev_repair) {
        
        HashMap map = dev_repairService.list(page,dev_repair);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_repairService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_repairService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_repair dev_repair) {
        
        HashMap map = dev_repairService.store(dev_repair);
        
        return map;
    }
}

