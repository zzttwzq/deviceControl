package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Area;
import com.qlzw.smartwc.mapper.AreaMapper;
import com.qlzw.smartwc.repository.AreaRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class AreaService {

    @Autowired
    private AreaMapper areaMapper; 

    @Autowired
    private AreaRepository areaRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Area area) {
        
        List<Area> list = areaMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        areaMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Area area = areaMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,area);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Area area) {
        
        Long id = area.getId() != null ? area.getId() : 0;
        
        if (id > 0) {
            areaMapper.update(area);
        } else {
            areaMapper.insert(area);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,area);
        
        return map;
    }

}

