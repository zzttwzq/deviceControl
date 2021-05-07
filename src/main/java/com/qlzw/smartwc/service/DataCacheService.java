package com.qlzw.smartwc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.qlzw.smartwc.utils.ObjectSerializeUtil;

import java.util.HashMap;

@Service
public class DataCacheService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setDataWithKey(String key, Object obj, int timeout) {

//        HashMap<String, Object> ops = stringRedisTemplate.opsForCluster();


    }

    public Object getDataWithKey() {

        return null;
    }
}
