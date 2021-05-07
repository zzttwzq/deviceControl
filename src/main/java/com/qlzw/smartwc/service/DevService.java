package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev;
import com.qlzw.smartwc.mapper.DevMapper;
import com.qlzw.smartwc.repository.DevRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class DevService {

    @Autowired
    private DevMapper devMapper; 

    @Autowired
    private DevRepository devRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev dev) {

        List<Dev> list = devMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        devMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev dev = devMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev dev) {
        
        Long id = dev.getId() != null ? dev.getId() : 0;
        
        if (id > 0) {
            devMapper.update(dev);
        } else {
            devMapper.insert(dev);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev);
        
        return map;
    }

}

