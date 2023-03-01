package com.kagami.controller;

import com.kagami.pojo.MyMessage;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 生产者
 **/
@RestController
@RequestMapping("/api/testRocketMQ")
public class TestProducerController {

    /**
     * 用于发送消息到 RocketMQ 的api
     */
    @Resource
    public RocketMQTemplate rocketMQTemplate;

    @GetMapping("/sendMsg")
    public String testSendMsg() {
        String topic = "test-topic";
        MyMessage message = new MyMessage();
        message.setId(1);
        message.setName("陈登宝");
        message.setStatus("default");
        message.setCreateTime(new Date());
        // 发送消息
        rocketMQTemplate.convertAndSend(topic, message);

        return "send message success";
    }
}
