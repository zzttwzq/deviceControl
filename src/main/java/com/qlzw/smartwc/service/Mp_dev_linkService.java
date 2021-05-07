package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Mp_dev_link;
import com.qlzw.smartwc.mapper.Mp_dev_linkMapper;
import com.qlzw.smartwc.repository.Mp_dev_linkRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Mp_dev_linkService {

    @Autowired
    private Mp_dev_linkMapper mp_dev_linkMapper; 

    @Autowired
    private Mp_dev_linkRepository mp_dev_linkRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Mp_dev_link mp_dev_link) {
        
        List<Mp_dev_link> list = mp_dev_linkMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        mp_dev_linkMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Mp_dev_link mp_dev_link = mp_dev_linkMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,mp_dev_link);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Mp_dev_link mp_dev_link) {
        
        Long id = mp_dev_link.getId() != null ? mp_dev_link.getId() : 0;
        
        if (id > 0) {
            mp_dev_linkMapper.update(mp_dev_link);
        } else {
            mp_dev_linkMapper.insert(mp_dev_link);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,mp_dev_link);
        
        return map;
    }

}

