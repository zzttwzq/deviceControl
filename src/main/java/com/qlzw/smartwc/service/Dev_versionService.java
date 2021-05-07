package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_version;
import com.qlzw.smartwc.mapper.Dev_versionMapper;
import com.qlzw.smartwc.repository.Dev_versionRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_versionService {

    @Autowired
    private Dev_versionMapper dev_versionMapper; 

    @Autowired
    private Dev_versionRepository dev_versionRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_version dev_version) {
        
        List<Dev_version> list = dev_versionMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_versionMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_version dev_version = dev_versionMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_version);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_version dev_version) {
        
        Long id = dev_version.getId() != null ? dev_version.getId() : 0;
        
        if (id > 0) {
            dev_versionMapper.update(dev_version);
        } else {
            dev_versionMapper.insert(dev_version);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_version);
        
        return map;
    }

}

