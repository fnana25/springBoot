package com.na.springboot.controller;

import com.na.springboot.controller.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * IndexController
 *
 * @author fengna
 * @date 19/2/21 21:33
 */
@RestController
@Api(description = "首页相关API")
public class IndexController {

    /**
     * 首页
     * @return hello
     */
    @ApiOperation(value="首页", notes="首页展示")
    @GetMapping("index")
    public String index(){

        return "hello";
    }

    /**
     * 获取user
     * @return user
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("user/{id}")
    public User getUser(@PathVariable Long id){

        return new User(1L,"fengna","692098869@qq.com");
    }
}
