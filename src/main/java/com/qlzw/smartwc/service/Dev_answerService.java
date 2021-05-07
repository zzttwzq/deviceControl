package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_answer;
import com.qlzw.smartwc.mapper.Dev_answerMapper;
import com.qlzw.smartwc.repository.Dev_answerRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_answerService {

    @Autowired
    private Dev_answerMapper dev_answerMapper; 

    @Autowired
    private Dev_answerRepository dev_answerRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_answer dev_answer) {
        
        List<Dev_answer> list = dev_answerMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_answerMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_answer dev_answer = dev_answerMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_answer);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_answer dev_answer) {
        
        Long id = dev_answer.getId() != null ? dev_answer.getId() : 0;
        
        if (id > 0) {
            dev_answerMapper.update(dev_answer);
        } else {
            dev_answerMapper.insert(dev_answer);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_answer);
        
        return map;
    }

}

