package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Rfid_change;
import com.qlzw.smartwc.service.Rfid_changeService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/rfid_change")
@RestController
public class Rfid_changeController {

    @Autowired
    private Rfid_changeService rfid_changeService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Rfid_change rfid_change) {
        
        HashMap map = rfid_changeService.list(page,rfid_change);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = rfid_changeService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = rfid_changeService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Rfid_change rfid_change) {
        
        HashMap map = rfid_changeService.store(rfid_change);
        
        return map;
    }
}

