package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Section;
import com.qlzw.smartwc.mapper.SectionMapper;
import com.qlzw.smartwc.repository.SectionRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class SectionService {

    @Autowired
    private SectionMapper sectionMapper; 

    @Autowired
    private SectionRepository sectionRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Section section) {
        
        List<Section> list = sectionMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        sectionMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Section section = sectionMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,section);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Section section) {
        
        Long id = section.getId() != null ? section.getId() : 0;
        
        if (id > 0) {
            sectionMapper.update(section);
        } else {
            sectionMapper.insert(section);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,section);
        
        return map;
    }

}

