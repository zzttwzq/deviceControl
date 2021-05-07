package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_info;
import com.qlzw.smartwc.mapper.Dev_infoMapper;
import com.qlzw.smartwc.repository.Dev_infoRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_infoService {

    @Autowired
    private Dev_infoMapper dev_infoMapper; 

    @Autowired
    private Dev_infoRepository dev_infoRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_info dev_info) {
        
        List<Dev_info> list = dev_infoMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_infoMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_info dev_info = dev_infoMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_info);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_info dev_info) {
        
        Long id = dev_info.getId() != null ? dev_info.getId() : 0;
        
        if (id > 0) {
            dev_infoMapper.update(dev_info);
        } else {
            dev_infoMapper.insert(dev_info);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_info);
        
        return map;
    }

}

