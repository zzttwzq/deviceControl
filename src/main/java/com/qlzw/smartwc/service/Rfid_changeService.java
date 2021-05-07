package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Rfid_change;
import com.qlzw.smartwc.mapper.Rfid_changeMapper;
import com.qlzw.smartwc.repository.Rfid_changeRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Rfid_changeService {

    @Autowired
    private Rfid_changeMapper rfid_changeMapper; 

    @Autowired
    private Rfid_changeRepository rfid_changeRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Rfid_change rfid_change) {
        
        List<Rfid_change> list = rfid_changeMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        rfid_changeMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Rfid_change rfid_change = rfid_changeMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,rfid_change);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Rfid_change rfid_change) {
        
        Long id = rfid_change.getId() != null ? rfid_change.getId() : 0;
        
        if (id > 0) {
            rfid_changeMapper.update(rfid_change);
        } else {
            rfid_changeMapper.insert(rfid_change);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,rfid_change);
        
        return map;
    }

}

