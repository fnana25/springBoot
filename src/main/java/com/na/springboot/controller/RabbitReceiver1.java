package com.na.springboot.controller;

import com.na.springboot.services.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收
 *
 * @author fengna
 * @date 2019/3/4
 */
@Slf4j
@Component
public class RabbitReceiver1 {

    @RabbitListener(queues = "hello")
    public void receive(String context){
        log.info("receive1 : {}",context);
    }

    @RabbitListener(queues = "object")
    public void receiveUser(User user) {
        System.out.println("Receive object : " + user);
    }

    @RabbitListener(queues = "na.message")
    public void receiveTopicMessage(String context) {
        System.out.println("Receive messageQueue context : " + context);
    }

    @RabbitListener(queues = "na.messages")
    public void receiveTopicMessages(String context) {
        System.out.println("Receive messagesQueue context : " + context);
    }
}
