package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Api;
import com.qlzw.smartwc.service.ApiService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Api api) {
        
        HashMap map = apiService.list(page,api);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = apiService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = apiService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Api api) {
        
        HashMap map = apiService.store(api);
        
        return map;
    }
}

