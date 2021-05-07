package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Msg_log;
import com.qlzw.smartwc.mapper.Msg_logMapper;
import com.qlzw.smartwc.repository.Msg_logRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Msg_logService {

    @Autowired
    private Msg_logMapper msg_logMapper; 

    @Autowired
    private Msg_logRepository msg_logRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Msg_log msg_log) {
        
        List<Msg_log> list = msg_logMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        msg_logMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Msg_log msg_log = msg_logMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,msg_log);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Msg_log msg_log) {
        
        Long id = msg_log.getId() != null ? msg_log.getId() : 0;
        
        if (id > 0) {
            msg_logMapper.update(msg_log);
        } else {
            msg_logMapper.insert(msg_log);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,msg_log);
        
        return map;
    }

}

