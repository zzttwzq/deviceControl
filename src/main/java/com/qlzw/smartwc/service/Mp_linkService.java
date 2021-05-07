package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Mp_link;
import com.qlzw.smartwc.mapper.Mp_linkMapper;
import com.qlzw.smartwc.repository.Mp_linkRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Mp_linkService {

    @Autowired
    private Mp_linkMapper mp_linkMapper; 

    @Autowired
    private Mp_linkRepository mp_linkRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Mp_link mp_link) {
        
        List<Mp_link> list = mp_linkMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        mp_linkMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Mp_link mp_link = mp_linkMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,mp_link);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Mp_link mp_link) {
        
        Long id = mp_link.getId() != null ? mp_link.getId() : 0;
        
        if (id > 0) {
            mp_linkMapper.update(mp_link);
        } else {
            mp_linkMapper.insert(mp_link);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,mp_link);
        
        return map;
    }

}

