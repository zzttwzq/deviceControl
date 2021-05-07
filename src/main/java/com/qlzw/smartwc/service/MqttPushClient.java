package com.qlzw.smartwc.service;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by wuzhiqiang on 2020/6/3.
 */
@Service
public class MqttPushClient {

    @Autowired
    private PushCallBack pushCallback;

    private static MqttClient client;

    public static MqttClient getClient() {
        return client;
    }

    public static void setClient(MqttClient client) {
        MqttPushClient.client = client;
    }

    /**
     * 连接
     * @param host .
     * @param username .
     * @param password .
     */
    public void connect(String host, String username, String password) {

        MqttClient client;

        try {

            client = new MqttClient(host, MqttClient.generateClientId(), new MemoryPersistence());

            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            options.setConnectionTimeout(30);
            options.setKeepAliveInterval(20);

            this.setClient(client);

            try {

                client.setCallback(pushCallback);
                client.connect(options);

                System.out.println("MqttClient connect success!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
     * 发布，默认qos为0，非持久化
     *
     * @param topic       .
     * @param pushMessage .
     */
    public void publish(String topic, String pushMessage) {
        publish(0, false, topic, pushMessage);
    }

    /**
     * 发布主题和消息队列
     *
     * @param qos         .
     * @param retained    .
     * @param topic       .
     * @param pushMessage .
     */
    public void publish(int qos, boolean retained, String topic, String pushMessage) {

        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(pushMessage.getBytes());

        try {

            this.client.publish(topic,message);

        } catch (MqttPersistenceException e) {

            e.printStackTrace();

        } catch (MqttException e) {

            e.printStackTrace();

        }
    }

    /**
     * 订阅某个主题，qos默认为0
     *
     * @param topic .
     */
    public void subscribe(String topic) {
        subscribe(topic, 0);
    }

    /**
     * 订阅某个主题
     *
     * @param topic .
     * @param qos .
     */
    public void subscribe(String topic, int qos) {
        try {
            MqttPushClient.getClient().subscribe(topic, qos);

            System.out.println("subscribe topic:"+topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
