package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_repair_link;
import com.qlzw.smartwc.mapper.Dev_repair_linkMapper;
import com.qlzw.smartwc.repository.Dev_repair_linkRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_repair_linkService {

    @Autowired
    private Dev_repair_linkMapper dev_repair_linkMapper; 

    @Autowired
    private Dev_repair_linkRepository dev_repair_linkRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_repair_link dev_repair_link) {
        
        List<Dev_repair_link> list = dev_repair_linkMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_repair_linkMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_repair_link dev_repair_link = dev_repair_linkMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_repair_link);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_repair_link dev_repair_link) {
        
        Long id = dev_repair_link.getId() != null ? dev_repair_link.getId() : 0;
        
        if (id > 0) {
            dev_repair_linkMapper.update(dev_repair_link);
        } else {
            dev_repair_linkMapper.insert(dev_repair_link);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_repair_link);
        
        return map;
    }

}

