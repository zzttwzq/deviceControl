package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_msg;
import com.qlzw.smartwc.mapper.Dev_msgMapper;
import com.qlzw.smartwc.repository.Dev_msgRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_msgService {

    @Autowired
    private Dev_msgMapper dev_msgMapper; 

    @Autowired
    private Dev_msgRepository dev_msgRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_msg dev_msg) {
        
        List<Dev_msg> list = dev_msgMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_msgMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_msg dev_msg = dev_msgMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_msg);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_msg dev_msg) {
        
        Long id = dev_msg.getId() != null ? dev_msg.getId() : 0;
        
        if (id > 0) {
            dev_msgMapper.update(dev_msg);
        } else {
            dev_msgMapper.insert(dev_msg);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_msg);
        
        return map;
    }

}

