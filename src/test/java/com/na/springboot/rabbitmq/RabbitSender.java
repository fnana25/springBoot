package com.na.springboot.rabbitmq;

import com.na.springboot.services.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息发送者
 *
 * @author fengna
 * @date 2019/3/4
 */
@Slf4j
@Component
public class RabbitSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String context) {

        log.info("send : {}" + context);
        rabbitTemplate.convertAndSend("hello", context);
    }

    public void sendUser(User user) {

        log.info("send : {}" + user.toString());
        rabbitTemplate.convertAndSend("object", user);
    }

    public void sendTopicMessage() {
        String context = "hi,i'm here！" + new Date();
        log.info("send topic : {}" + context);
        rabbitTemplate.convertAndSend("na", "na.message", context);
    }

    public void sendTopicMessages() {
        String context = "hi,i'm here!!" + new Date();
        log.info("send topic : {}", context);
        rabbitTemplate.convertAndSend("na", "na.messages", context);
    }

    public void sendFanoutMessage(){
        String context = "hello world! "+new Date();
        log.info("send fanout : {}"+context);
        rabbitTemplate.convertAndSend("fanoutExchange","",context);
    }
}
