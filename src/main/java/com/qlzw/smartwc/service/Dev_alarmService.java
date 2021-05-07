package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_alarm;
import com.qlzw.smartwc.mapper.Dev_alarmMapper;
import com.qlzw.smartwc.repository.Dev_alarmRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_alarmService {

    @Autowired
    private Dev_alarmMapper dev_alarmMapper; 

    @Autowired
    private Dev_alarmRepository dev_alarmRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_alarm dev_alarm) {
        
        List<Dev_alarm> list = dev_alarmMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_alarmMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_alarm dev_alarm = dev_alarmMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_alarm);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_alarm dev_alarm) {
        
        Long id = dev_alarm.getId() != null ? dev_alarm.getId() : 0;
        
        if (id > 0) {
            dev_alarmMapper.update(dev_alarm);
        } else {
            dev_alarmMapper.insert(dev_alarm);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_alarm);
        
        return map;
    }

}

