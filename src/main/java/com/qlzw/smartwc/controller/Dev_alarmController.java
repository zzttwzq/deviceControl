package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_alarm;
import com.qlzw.smartwc.service.Dev_alarmService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_alarm")
@RestController
public class Dev_alarmController {

    @Autowired
    private Dev_alarmService dev_alarmService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_alarm dev_alarm) {
        
        HashMap map = dev_alarmService.list(page,dev_alarm);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_alarmService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_alarmService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_alarm dev_alarm) {
        
        HashMap map = dev_alarmService.store(dev_alarm);
        
        return map;
    }
}

