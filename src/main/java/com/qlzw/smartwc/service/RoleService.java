package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Role;
import com.qlzw.smartwc.mapper.RoleMapper;
import com.qlzw.smartwc.repository.RoleRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper; 

    @Autowired
    private RoleRepository roleRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Role role) {
        
        List<Role> list = roleMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        roleMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Role role = roleMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,role);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Role role) {
        
        Long id = role.getId() != null ? role.getId() : 0;
        
        if (id > 0) {
            roleMapper.update(role);
        } else {
            roleMapper.insert(role);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,role);
        
        return map;
    }

}

