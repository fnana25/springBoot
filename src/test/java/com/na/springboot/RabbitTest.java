package com.na.springboot;

import com.na.springboot.controller.RabbitSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void sender(){
        rabbitSender.send();
    }
}
