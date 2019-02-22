package com.na.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author fengna
 * @date 19/2/21 21:33
 */
@RestController
public class TestController {

    @RequestMapping("index")
    public String index(){

        return "hello";
    }
}
