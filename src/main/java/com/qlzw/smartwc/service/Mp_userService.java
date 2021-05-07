package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Mp_user;
import com.qlzw.smartwc.mapper.Mp_userMapper;
import com.qlzw.smartwc.repository.Mp_userRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Mp_userService {

    @Autowired
    private Mp_userMapper mp_userMapper; 

    @Autowired
    private Mp_userRepository mp_userRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Mp_user mp_user) {
        
        List<Mp_user> list = mp_userMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        mp_userMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Mp_user mp_user = mp_userMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,mp_user);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Mp_user mp_user) {
        
        Long id = mp_user.getId() != null ? mp_user.getId() : 0;
        
        if (id > 0) {
            mp_userMapper.update(mp_user);
        } else {
            mp_userMapper.insert(mp_user);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,mp_user);
        
        return map;
    }

}

