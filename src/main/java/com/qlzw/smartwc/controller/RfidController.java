package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Rfid;
import com.qlzw.smartwc.service.RfidService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/rfid")
@RestController
public class RfidController {

    @Autowired
    private RfidService rfidService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Rfid rfid) {
        
        HashMap map = rfidService.list(page,rfid);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = rfidService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = rfidService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Rfid rfid) {
        
        HashMap map = rfidService.store(rfid);
        
        return map;
    }
}

