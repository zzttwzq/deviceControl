package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Email_send;
import com.qlzw.smartwc.service.Email_sendService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/email_send")
@RestController
public class Email_sendController {

    @Autowired
    private Email_sendService email_sendService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Email_send email_send) {
        
        HashMap map = email_sendService.list(page,email_send);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = email_sendService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = email_sendService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Email_send email_send) {
        
        HashMap map = email_sendService.store(email_send);
        
        return map;
    }
}

