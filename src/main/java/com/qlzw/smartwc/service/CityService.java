package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.City;
import com.qlzw.smartwc.mapper.CityMapper;
import com.qlzw.smartwc.repository.CityRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class CityService {

    @Autowired
    private CityMapper cityMapper; 

    @Autowired
    private CityRepository cityRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated City city) {
        
        List<City> list = cityMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        cityMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        City city = cityMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,city);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated City city) {
        
        Long id = city.getId() != null ? city.getId() : 0;
        
        if (id > 0) {
            cityMapper.update(city);
        } else {
            cityMapper.insert(city);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,city);
        
        return map;
    }

}

