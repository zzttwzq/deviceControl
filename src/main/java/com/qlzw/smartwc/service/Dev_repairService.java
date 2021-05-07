package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Dev_repair;
import com.qlzw.smartwc.mapper.Dev_repairMapper;
import com.qlzw.smartwc.repository.Dev_repairRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Dev_repairService {

    @Autowired
    private Dev_repairMapper dev_repairMapper; 

    @Autowired
    private Dev_repairRepository dev_repairRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Dev_repair dev_repair) {
        
        List<Dev_repair> list = dev_repairMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        dev_repairMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Dev_repair dev_repair = dev_repairMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_repair);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Dev_repair dev_repair) {
        
        Long id = dev_repair.getId() != null ? dev_repair.getId() : 0;
        
        if (id > 0) {
            dev_repairMapper.update(dev_repair);
        } else {
            dev_repairMapper.insert(dev_repair);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,dev_repair);
        
        return map;
    }

}

