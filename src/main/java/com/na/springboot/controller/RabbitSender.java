package com.na.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  消息发送者
 *
 * @author fengna
 * @date 2019/3/4
 */
@Slf4j
@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){

        String context = "hello : " + new Date();
        log.info("send : " + context);
        rabbitTemplate.convertAndSend("hello",context);
    }
}
