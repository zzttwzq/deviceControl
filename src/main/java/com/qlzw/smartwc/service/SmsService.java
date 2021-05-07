package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Sms;
import com.qlzw.smartwc.mapper.SmsMapper;
import com.qlzw.smartwc.repository.SmsRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class SmsService {

    @Autowired
    private SmsMapper smsMapper; 

    @Autowired
    private SmsRepository smsRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Sms sms) {
        
        List<Sms> list = smsMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        smsMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Sms sms = smsMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,sms);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Sms sms) {
        
        Long id = sms.getId() != null ? sms.getId() : 0;
        
        if (id > 0) {
            smsMapper.update(sms);
        } else {
            smsMapper.insert(sms);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,sms);
        
        return map;
    }

}

