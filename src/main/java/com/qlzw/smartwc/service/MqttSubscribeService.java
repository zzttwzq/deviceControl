package com.qlzw.smartwc.service;

import com.alibaba.fastjson.JSONObject;
import com.qlzw.smartwc.task.MqttMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by wuzhiqiang on 2020/6/3.
 */
@Service
public class MqttSubscribeService {

    private static final Logger logger = LoggerFactory.getLogger(MqttMonitor.class);

    public void handleToServer(String topic, String snno, String msg) {

        JSONObject jsStr = JSONObject.parseObject(msg); //将字符串{“id”：1}
        String method = jsStr.getString("method");//获取id的值

        logger.debug(topic);
        logger.debug(snno);
        logger.debug(method);
    }

    public void handleToClient(String topic, String snno, String msg) {

        logger.debug(topic);
        logger.debug(snno);
        logger.debug(msg);
    }
}
