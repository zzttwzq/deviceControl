package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_cmd;
import com.qlzw.smartwc.service.Dev_cmdService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_cmd")
@RestController
public class Dev_cmdController {

    @Autowired
    private Dev_cmdService dev_cmdService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_cmd dev_cmd) {
        
        HashMap map = dev_cmdService.list(page,dev_cmd);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_cmdService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_cmdService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_cmd dev_cmd) {
        
        HashMap map = dev_cmdService.store(dev_cmd);
        
        return map;
    }
}

