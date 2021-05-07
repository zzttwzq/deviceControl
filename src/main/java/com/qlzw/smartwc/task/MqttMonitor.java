package com.qlzw.smartwc.task;

import com.qlzw.smartwc.service.EchoServerHandler;
import com.qlzw.smartwc.service.MqttPushClient;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wuzhiqiang on 2020/6/3.
 */
@Component
@Order(value = 1)
public class MqttMonitor implements ApplicationRunner{

    @Autowired
    private MqttPushClient mqttPushClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        mqttPushClient.connect("tcp://118.25.141.216:1993","usern","pwd123");
        mqttPushClient.subscribe("$biz/#");

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup group = new NioEventLoopGroup();
        try {

            ServerBootstrap sb = new ServerBootstrap();
            sb.option(ChannelOption.SO_BACKLOG, 1024);
            sb.group(group, bossGroup) // 绑定线程池
                    .channel(NioServerSocketChannel.class) // 指定使用的channe
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 绑定客户端连接时候触发操作

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            System.out.println("信息：有一客户端链接到本服务端  +" +
                                    "IP:"+ ch.localAddress().getHostName() +
                                    "Port:" + ch.localAddress().getPort());

                            ch.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
                            ch.pipeline().addLast(new EchoServerHandler()); // 客户端触发操作
                            ch.pipeline().addLast(new ByteArrayEncoder());
                        }
                    });
            ChannelFuture cf = sb.bind("127.0.0.1",7878).sync(); // 服务器异步创建绑定
            System.out.println(" 启动监听： " + cf.channel().localAddress());

        } finally {

            group.shutdownGracefully().sync(); // 释放线程池资源
            bossGroup.shutdownGracefully().sync();
        }
    }
}
