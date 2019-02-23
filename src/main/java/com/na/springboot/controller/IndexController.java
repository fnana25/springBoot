package com.na.springboot.controller;

import com.na.springboot.controller.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author fengna
 * @date 19/2/21 21:33
 */
@RestController
public class IndexController {

    /**
     * 首页
     * @return hello
     */
    @RequestMapping("index")
    public String index(){

        return "hello";
    }

    /**
     * 获取user
     * @return user
     */
    @RequestMapping("user")
    public User getUser(){

        return new User("fengna","692098869@qq.com");
    }
}
