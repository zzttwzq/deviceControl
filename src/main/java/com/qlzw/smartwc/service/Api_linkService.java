package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Api_link;
import com.qlzw.smartwc.mapper.Api_linkMapper;
import com.qlzw.smartwc.repository.Api_linkRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Api_linkService {

    @Autowired
    private Api_linkMapper api_linkMapper; 

    @Autowired
    private Api_linkRepository api_linkRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Api_link api_link) {
        
        List<Api_link> list = api_linkMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        api_linkMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Api_link api_link = api_linkMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,api_link);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Api_link api_link) {
        
        Long id = api_link.getId() != null ? api_link.getId() : 0;
        
        if (id > 0) {
            api_linkMapper.update(api_link);
        } else {
            api_linkMapper.insert(api_link);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,api_link);
        
        return map;
    }

}

