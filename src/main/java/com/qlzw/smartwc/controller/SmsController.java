package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Sms;
import com.qlzw.smartwc.service.SmsService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/sms")
@RestController
public class SmsController {

    @Autowired
    private SmsService smsService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Sms sms) {
        
        HashMap map = smsService.list(page,sms);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = smsService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = smsService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Sms sms) {
        
        HashMap map = smsService.store(sms);
        
        return map;
    }
}

