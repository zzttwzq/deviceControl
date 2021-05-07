package com.qlzw.smartwc.service;

import com.qlzw.smartwc.model.Mp_user_share;
import com.qlzw.smartwc.mapper.Mp_user_shareMapper;
import com.qlzw.smartwc.repository.Mp_user_shareRepository;

import com.qlzw.smartwc.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Service;

import com.qlzw.smartwc.service.ResponseService;

import java.util.*;

@Service
public class Mp_user_shareService {

    @Autowired
    private Mp_user_shareMapper mp_user_shareMapper; 

    @Autowired
    private Mp_user_shareRepository mp_user_shareRepository; 

    @Autowired
    private ResponseService responseService; 

    // 获取列表
    public HashMap<String, Object> list(Pager page,@Validated Mp_user_share mp_user_share) {
        
        List<Mp_user_share> list = mp_user_shareMapper.list(page.getPage(),page.getSize());
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,list);
        
        return map;
    }

    // 删除
    public HashMap<String, Object> delete(@PathVariable("id") Long id) {
        
        mp_user_shareMapper.delete(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,null);
        
        return map;
    }

    // 查看详情
    public HashMap<String, Object> show(@PathVariable("id") Long id) {
        
        Mp_user_share mp_user_share = mp_user_shareMapper.show(id);
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,mp_user_share);
        
        return map;
    }

    // 插入，保存
    public HashMap<String, Object> store(@Validated Mp_user_share mp_user_share) {
        
        Long id = mp_user_share.getId() != null ? mp_user_share.getId() : 0;
        
        if (id > 0) {
            mp_user_shareMapper.update(mp_user_share);
        } else {
            mp_user_shareMapper.insert(mp_user_share);
        }
        
        HashMap map = responseService.getReturnResponse(RESPONSE_STATUS.RESPONSE_STATUS_SUCCESS,mp_user_share);
        
        return map;
    }

}

