package com.na.springboot;

import com.na.springboot.rabbitmq.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.na.springboot.services.models.User;
import java.util.Date;

/**
 * rabbit 测试
 *
 * @author fengna
 * @date 2019/3/4
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitTest {

    @Autowired
    private RabbitSender rabbitSender;

    @Test
    public void sender() {
        rabbitSender.send("hello : " + new Date());
    }

    @Test
    public void mutiReceiverTest() {
        for (int i = 0; i < 100; i++) {
            rabbitSender.send("hello : " + i);
        }
    }

    @Test
    public void sendUser(){

        rabbitSender.sendUser(new User(20L,"fengna22","6900423@qq.com"));
    }

    @Test
    public void sendTopicMessage(){
        rabbitSender.sendTopicMessage();
        rabbitSender.sendTopicMessages();
    }

    @Test
    public void sendFanoutMessage(){
        rabbitSender.sendFanoutMessage();
    }
}
