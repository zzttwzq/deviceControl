package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Rfid;
import com.qlzw.smartwc.mapper.RfidMapper;
import com.qlzw.smartwc.repository.RfidRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class RfidService {

    @Autowired
    private RfidMapper rfidMapper; 

    @Autowired
    private RfidRepository rfidRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Rfid rfid) {
        
        List<Rfid> list = rfidMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        rfidMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Rfid rfid = rfidMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,rfid);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Rfid rfid) {
        
        Long id = rfid.getId() != null ? rfid.getId() : 0;
        
        if (id > 0) {
            rfidMapper.update(rfid);
        } else {
            rfidMapper.insert(rfid);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,rfid);
        
        return map;
    }

}

