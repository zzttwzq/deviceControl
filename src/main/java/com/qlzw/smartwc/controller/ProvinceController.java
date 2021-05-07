package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Province;
import com.qlzw.smartwc.service.ProvinceService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/province")
@RestController
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Province province) {
        
        HashMap map = provinceService.list(page,province);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = provinceService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = provinceService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Province province) {
        
        HashMap map = provinceService.store(province);
        
        return map;
    }
}

