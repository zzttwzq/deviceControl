package com.qlzw.smartwc.service;

import com.qlzw.smartwc.task.MqttMonitor;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wuzhiqiang on 2020/6/3.
 */
@Component
public class PushCallBack implements MqttCallback{

    private static final Logger logger = LoggerFactory.getLogger(MqttMonitor.class);

    @Autowired
    private MqttSubscribeService mqttSubscribeService;

    @Override
    public void connectionLost(Throwable throwable) {

        System.out.println("connectionLost!");
        System.out.println(throwable);
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

        String [] strArr = s.split("/");
        String HandleType = strArr[1];

        logger.debug(HandleType);

        if (HandleType.equals("toClient")) {

            mqttSubscribeService.handleToClient(s,strArr[2],mqttMessage.toString());
        }
        else if (HandleType.equals("toServer")) {

            mqttSubscribeService.handleToServer(s,strArr[2],mqttMessage.toString());
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken){

        logger.debug("deliveryComplete!");

        System.out.println("deliveryComplete!");
        System.out.println(iMqttDeliveryToken);
    }
}
