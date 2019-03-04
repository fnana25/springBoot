package com.na.springboot.services.impl;

import com.na.springboot.services.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * 邮件服务
 *
 * @author fengna
 * @date 2019/3/4
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.address")
    private String from;

    @Override
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setTo(content);
        try {
            mailSender.send(message);
            log.info("邮件已经发送出去。");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("邮件发送异常");
        }
    }
}
