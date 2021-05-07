package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_update;
import com.qlzw.smartwc.mapper.Dev_updateMapper;
import com.qlzw.smartwc.repository.Dev_updateRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_updateService {

    @Autowired
    private Dev_updateMapper dev_updateMapper; 

    @Autowired
    private Dev_updateRepository dev_updateRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_update dev_update) {
        
        List<Dev_update> list = dev_updateMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_updateMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_update dev_update = dev_updateMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_update);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_update dev_update) {
        
        Long id = dev_update.getId() != null ? dev_update.getId() : 0;
        
        if (id > 0) {
            dev_updateMapper.update(dev_update);
        } else {
            dev_updateMapper.insert(dev_update);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_update);
        
        return map;
    }

}

