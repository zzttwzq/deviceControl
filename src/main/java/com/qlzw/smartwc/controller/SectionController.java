package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Section;
import com.qlzw.smartwc.service.SectionService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/section")
@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Section section) {
        
        HashMap map = sectionService.list(page,section);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = sectionService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = sectionService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Section section) {
        
        HashMap map = sectionService.store(section);
        
        return map;
    }
}

