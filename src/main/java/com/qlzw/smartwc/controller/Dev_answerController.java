package com.qlzw.smartwc.controller;

import com.qlzw.smartwc.model.Dev_answer;
import com.qlzw.smartwc.service.Dev_answerService;
import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dev_answer")
@RestController
public class Dev_answerController {

    @Autowired
    private Dev_answerService dev_answerService; 

    // 获取列表
    @GetMapping
    public HashMap<String, Object> list(Pager page,Dev_answer dev_answer) {
        
        HashMap map = dev_answerService.list(page,dev_answer);
        
        return map;
    }

    // 删除
    @GetMapping("/delete/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        HashMap map = dev_answerService.delete(id);
        
        return map;
    }

    // 查看详情
    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        HashMap map = dev_answerService.show(id);
        
        return map;
    }

    // 插入，保存
    @PostMapping
    public HashMap<String, Object> store(@Validated Dev_answer dev_answer) {
        
        HashMap map = dev_answerService.store(dev_answer);
        
        return map;
    }
}

