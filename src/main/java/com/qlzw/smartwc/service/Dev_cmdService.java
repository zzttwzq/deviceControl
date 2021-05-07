package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_cmd;
import com.qlzw.smartwc.mapper.Dev_cmdMapper;
import com.qlzw.smartwc.repository.Dev_cmdRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_cmdService {

    @Autowired
    private Dev_cmdMapper dev_cmdMapper; 

    @Autowired
    private Dev_cmdRepository dev_cmdRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_cmd dev_cmd) {
        
        List<Dev_cmd> list = dev_cmdMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_cmdMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_cmd dev_cmd = dev_cmdMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_cmd);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_cmd dev_cmd) {
        
        Long id = dev_cmd.getId() != null ? dev_cmd.getId() : 0;
        
        if (id > 0) {
            dev_cmdMapper.update(dev_cmd);
        } else {
            dev_cmdMapper.insert(dev_cmd);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_cmd);
        
        return map;
    }

}

