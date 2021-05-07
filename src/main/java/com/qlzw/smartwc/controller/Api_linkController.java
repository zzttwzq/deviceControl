package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Api_link;
import com.qlzw.smartwc.service.Api_linkService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api_link")
@RestController
public class Api_linkController {

    @Autowired
    private Api_linkService api_linkService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Api_link api_link) {
        
        HashMap map = api_linkService.list(page,api_link);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = api_linkService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = api_linkService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Api_link api_link) {
        
        HashMap map = api_linkService.store(api_link);
        
        return map;
    }
}

