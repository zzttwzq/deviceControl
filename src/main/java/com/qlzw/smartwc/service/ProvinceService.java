package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Province;
import com.qlzw.smartwc.mapper.ProvinceMapper;
import com.qlzw.smartwc.repository.ProvinceRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper; 

    @Autowired
    private ProvinceRepository provinceRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Province province) {
        
        List<Province> list = provinceMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        provinceMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Province province = provinceMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,province);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Province province) {
        
        Long id = province.getId() != null ? province.getId() : 0;
        
        if (id > 0) {
            provinceMapper.update(province);
        } else {
            provinceMapper.insert(province);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,province);
        
        return map;
    }

}

