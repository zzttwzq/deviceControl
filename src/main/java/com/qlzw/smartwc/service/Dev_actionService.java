package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_action;
import com.qlzw.smartwc.mapper.Dev_actionMapper;
import com.qlzw.smartwc.repository.Dev_actionRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_actionService {

    @Autowired
    private Dev_actionMapper dev_actionMapper; 

    @Autowired
    private Dev_actionRepository dev_actionRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_action dev_action) {
        
        List<Dev_action> list = dev_actionMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_actionMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_action dev_action = dev_actionMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_action);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_action dev_action) {
        
        Long id = dev_action.getId() != null ? dev_action.getId() : 0;
        
        if (id > 0) {
            dev_actionMapper.update(dev_action);
        } else {
            dev_actionMapper.insert(dev_action);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_action);
        
        return map;
    }

}

