package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Mp_user_share;
import com.qlzw.smartwc.service.Mp_user_shareService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/mp_user_share")
@RestController
public class Mp_user_shareController {

    @Autowired
    private Mp_user_shareService mp_user_shareService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Mp_user_share mp_user_share) {
        
        HashMap map = mp_user_shareService.list(page,mp_user_share);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = mp_user_shareService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = mp_user_shareService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Mp_user_share mp_user_share) {
        
        HashMap map = mp_user_shareService.store(mp_user_share);
        
        return map;
    }
}

