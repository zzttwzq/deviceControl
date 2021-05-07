package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Msg_log;
import com.qlzw.smartwc.service.Msg_logService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/msg_log")
@RestController
public class Msg_logController {

    @Autowired
    private Msg_logService msg_logService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Msg_log msg_log) {
        
        HashMap map = msg_logService.list(page,msg_log);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = msg_logService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = msg_logService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Msg_log msg_log) {
        
        HashMap map = msg_logService.store(msg_log);
        
        return map;
    }
}

