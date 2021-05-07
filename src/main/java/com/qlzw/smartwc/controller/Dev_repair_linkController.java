package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_repair_link;
import com.qlzw.smartwc.service.Dev_repair_linkService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_repair_link")
@RestController
public class Dev_repair_linkController {

    @Autowired
    private Dev_repair_linkService dev_repair_linkService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_repair_link dev_repair_link) {
        
        HashMap map = dev_repair_linkService.list(page,dev_repair_link);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_repair_linkService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_repair_linkService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_repair_link dev_repair_link) {
        
        HashMap map = dev_repair_linkService.store(dev_repair_link);
        
        return map;
    }
}

