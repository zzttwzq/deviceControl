package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.City;
import com.qlzw.smartwc.service.CityService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/city")
@RestController
public class CityController {

    @Autowired
    private CityService cityService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,City city) {
        
        HashMap map = cityService.list(page,city);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = cityService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = cityService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated City city) {
        
        HashMap map = cityService.store(city);
        
        return map;
    }
}

