package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Mp_link;
import com.qlzw.smartwc.service.Mp_linkService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/mp_link")
@RestController
public class Mp_linkController {

    @Autowired
    private Mp_linkService mp_linkService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Mp_link mp_link) {
        
        HashMap map = mp_linkService.list(page,mp_link);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = mp_linkService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = mp_linkService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Mp_link mp_link) {
        
        HashMap map = mp_linkService.store(mp_link);
        
        return map;
    }
}

