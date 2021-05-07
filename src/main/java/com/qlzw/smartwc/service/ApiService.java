package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Api;
import com.qlzw.smartwc.mapper.ApiMapper;
import com.qlzw.smartwc.repository.ApiRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class ApiService {

    @Autowired
    private ApiMapper apiMapper; 

    @Autowired
    private ApiRepository apiRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Api api) {
        
        List<Api> list = apiMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        apiMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Api api = apiMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,api);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Api api) {
        
        Long id = api.getId() != null ? api.getId() : 0;
        
        if (id > 0) {
            apiMapper.update(api);
        } else {
            apiMapper.insert(api);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,api);
        
        return map;
    }

}

