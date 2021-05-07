package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Admin_link;
import com.qlzw.smartwc.mapper.Admin_linkMapper;
import com.qlzw.smartwc.repository.Admin_linkRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Admin_linkService {

    @Autowired
    private Admin_linkMapper admin_linkMapper; 

    @Autowired
    private Admin_linkRepository admin_linkRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Admin_link admin_link) {
        
        List<Admin_link> list = admin_linkMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        admin_linkMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Admin_link admin_link = admin_linkMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,admin_link);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Admin_link admin_link) {
        
        Long id = admin_link.getId() != null ? admin_link.getId() : 0;
        
        if (id > 0) {
            admin_linkMapper.update(admin_link);
        } else {
            admin_linkMapper.insert(admin_link);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,admin_link);
        
        return map;
    }

}

