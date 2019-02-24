package com.na.springboot.controller;

import com.na.springboot.services.UserService;
import com.na.springboot.services.models.User;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * 首页
 *
 * @author fengna
 * @date 19/2/21 21:33
 */
@Slf4j
@RestController
@RequestMapping("index")
@Api(description = "首页相关API")
public class IndexController {

    @Value("${com.na.title")
    private String title;

    @Autowired
    private UserService userService;

    /**
     * 首页
     * @return hello
     */
    @GetMapping
    @ApiOperation(value="首页", notes="首页展示")
    public String index(){

        return "hello";
    }

    /**
     * 获取user
     * @return user
     */
    @GetMapping("user/{id}")
    @ApiOperation("获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code = 400, message = "参数有误"),
            @ApiResponse(code = 404, message = "路径有误")
    })
    public User getUser(@PathVariable Long id){

        return new User(id,"fengna","692098869@qq.com");
    }

    @GetMapping("user/{name}")
    @ApiOperation("获取用户信息")
    public User getUser(@ApiParam(value = "姓名",required = true) @PathVariable String name){

        return userService.findByName(name);
    }
}
