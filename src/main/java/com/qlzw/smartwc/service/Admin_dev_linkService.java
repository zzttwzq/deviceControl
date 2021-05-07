package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Admin_dev_link;
import com.qlzw.smartwc.mapper.Admin_dev_linkMapper;
import com.qlzw.smartwc.repository.Admin_dev_linkRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Admin_dev_linkService {

    @Autowired
    private Admin_dev_linkMapper admin_dev_linkMapper; 

    @Autowired
    private Admin_dev_linkRepository admin_dev_linkRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Admin_dev_link admin_dev_link) {
        
        List<Admin_dev_link> list = admin_dev_linkMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        admin_dev_linkMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Admin_dev_link admin_dev_link = admin_dev_linkMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,admin_dev_link);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Admin_dev_link admin_dev_link) {
        
        Long id = admin_dev_link.getId() != null ? admin_dev_link.getId() : 0;
        
        if (id > 0) {
            admin_dev_linkMapper.update(admin_dev_link);
        } else {
            admin_dev_linkMapper.insert(admin_dev_link);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,admin_dev_link);
        
        return map;
    }

}

