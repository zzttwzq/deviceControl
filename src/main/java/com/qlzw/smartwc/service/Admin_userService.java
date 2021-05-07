package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Admin_user;
import com.qlzw.smartwc.mapper.Admin_userMapper;
import com.qlzw.smartwc.repository.Admin_userRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Admin_userService {

    @Autowired
    private Admin_userMapper admin_userMapper; 

    @Autowired
    private Admin_userRepository admin_userRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Admin_user admin_user) {
        
        List<Admin_user> list = admin_userMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        admin_userMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Admin_user admin_user = admin_userMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,admin_user);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Admin_user admin_user) {
        
        Long id = admin_user.getId() != null ? admin_user.getId() : 0;
        
        if (id > 0) {
            admin_userMapper.update(admin_user);
        } else {
            admin_userMapper.insert(admin_user);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,admin_user);
        
        return map;
    }

}

