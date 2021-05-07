package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_update_msg;
import com.qlzw.smartwc.mapper.Dev_update_msgMapper;
import com.qlzw.smartwc.repository.Dev_update_msgRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_update_msgService {

    @Autowired
    private Dev_update_msgMapper dev_update_msgMapper; 

    @Autowired
    private Dev_update_msgRepository dev_update_msgRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_update_msg dev_update_msg) {
        
        List<Dev_update_msg> list = dev_update_msgMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_update_msgMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_update_msg dev_update_msg = dev_update_msgMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_update_msg);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_update_msg dev_update_msg) {
        
        Long id = dev_update_msg.getId() != null ? dev_update_msg.getId() : 0;
        
        if (id > 0) {
            dev_update_msgMapper.update(dev_update_msg);
        } else {
            dev_update_msgMapper.insert(dev_update_msg);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_update_msg);
        
        return map;
    }

}

