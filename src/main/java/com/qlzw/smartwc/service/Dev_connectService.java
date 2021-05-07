package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_connect;
import com.qlzw.smartwc.mapper.Dev_connectMapper;
import com.qlzw.smartwc.repository.Dev_connectRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_connectService {

    @Autowired
    private Dev_connectMapper dev_connectMapper; 

    @Autowired
    private Dev_connectRepository dev_connectRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_connect dev_connect) {
        
        List<Dev_connect> list = dev_connectMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_connectMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_connect dev_connect = dev_connectMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_connect);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_connect dev_connect) {
        
        Long id = dev_connect.getId() != null ? dev_connect.getId() : 0;
        
        if (id > 0) {
            dev_connectMapper.update(dev_connect);
        } else {
            dev_connectMapper.insert(dev_connect);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_connect);
        
        return map;
    }

}

