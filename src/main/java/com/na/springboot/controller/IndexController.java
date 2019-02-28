package com.na.springboot.controller;

import com.na.springboot.configurations.UserConfigTest;
import com.na.springboot.services.UserService;
import com.na.springboot.services.models.User;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
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

    @Value("${com.na.title}")
    private String title;

    @Value("${com.na.description}")
    private String description;

    @Autowired
    private UserConfigTest userConfigTest;

    @Autowired
    private UserService userService;

    /**
     * 首页
     * @return hello
     */
    @GetMapping
    @ApiOperation(value="首页", notes="首页展示")
    public String index(){

        return title+"-"+description+"-index";
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
    public User getUser(@PathVariable("id") Long id){

        return userService.findById(id);
    }

    /**
     * 获取用户信息
     * @param name 姓名
     * @return user
     */
    @GetMapping("user")
    @ApiOperation("获取用户信息")
    public User getUser(@ApiParam(value = "姓名",required = true) @RequestParam(value = "name") String name){

        return userService.findByName(name);
    }

    /**
     * 从配置文件获取对象配置测试
     * @return userConfigTest
     */
    @GetMapping("user-config-test")
    @ApiOperation("从配置文件获取对象配置测试")
    public UserConfigTest userConfigTest(){

        System.out.println(userConfigTest);
        return userConfigTest;
    }

    /**
     * 从缓存中获取user
     * @return userRedisTest
     */
    @GetMapping("user-redis-test")
    @Cacheable(value="com.na.springboot")
    @ApiOperation("从缓存中获取user")
    public User userRedisTest(@ApiParam(value = "姓名",required = true) @RequestParam(value = "name") String name){

        System.out.println("没有从缓存获取");
        return userService.findByName(name);
    }
}
