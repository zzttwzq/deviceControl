package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Area;
import com.qlzw.smartwc.service.AreaService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/area")
@RestController
public class AreaController {

    @Autowired
    private AreaService areaService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Area area) {
        
        HashMap map = areaService.list(page,area);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = areaService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = areaService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Area area) {
        
        HashMap map = areaService.store(area);
        
        return map;
    }
}

