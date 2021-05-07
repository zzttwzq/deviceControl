package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Email_send;
import com.qlzw.smartwc.mapper.Email_sendMapper;
import com.qlzw.smartwc.repository.Email_sendRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Email_sendService {

    @Autowired
    private Email_sendMapper email_sendMapper; 

    @Autowired
    private Email_sendRepository email_sendRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Email_send email_send) {
        
        List<Email_send> list = email_sendMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        email_sendMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Email_send email_send = email_sendMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,email_send);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Email_send email_send) {
        
        Long id = email_send.getId() != null ? email_send.getId() : 0;
        
        if (id > 0) {
            email_sendMapper.update(email_send);
        } else {
            email_sendMapper.insert(email_send);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,email_send);
        
        return map;
    }

}

