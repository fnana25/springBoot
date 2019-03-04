package com.na.springboot;

import com.na.springboot.services.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 发送邮件测试
 *
 * @author fengna
 * @date 2019/3/4
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendMail(){
        mailService.sendMail("fnana1125@163.com","testsimplemail","hellothisis");
    }
}
