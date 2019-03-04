package com.na.springboot.services;

/**
 * 右键服务
 *
 * @author fengna
 * @date 2019/3/4
 */
public interface MailService {

    /**
     * 发送邮件
     * @param to 接收者
     * @param subject 主题
     * @param content 内容
     */
    void sendMail(String to,String subject,String content);
}
