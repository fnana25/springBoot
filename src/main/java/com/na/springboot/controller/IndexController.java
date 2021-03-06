package com.na.springboot.controller;

import com.na.springboot.configurations.UserConfigTest;
import com.na.springboot.services.UserService;
import com.na.springboot.services.models.User;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;


/**
 * 首页
 *
 * @author fengna
 * @date 19/2/21 21:33
 */
@Slf4j
@RestController
@RequestMapping("index/user")
@Api(tags = "首页相关API")
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
     * 配置获取值测试
     *
     * @return hello
     */
    @GetMapping
    @ApiOperation(value = "首页", notes = "首页展示")
    public String index() {

        return title + "-" + description + "-index";
    }

    /**
     * 根据id获取用户信息
     *
     * @return user
     */
    @GetMapping("{id}")
    @ApiOperation("获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code = 400, message = "参数有误"),
            @ApiResponse(code = 404, message = "路径有误")
    })
    public User findUser(@PathVariable("id") Long id) {

        return userService.findById(id);
    }

    /**
     * 根据姓名获取用户信息
     *
     * @param name 姓名
     * @return user
     */
    @GetMapping("{name}")
    @ApiOperation("获取用户信息")
    public User findUser(@PathVariable("name") String name) {

        return userService.findByName(name);
    }

    /**
     * 从配置文件获取对象配置测试
     *
     * @return 配置对象
     */
    @GetMapping("test/config")
    @ApiOperation("从配置文件获取对象配置测试")
    public UserConfigTest userConfigTest() {

        System.out.println(userConfigTest);
        return userConfigTest;
    }

    /**
     * 从缓存中获取user
     *
     * @return userRedisTest
     */
    @GetMapping("test/redis")
    @Cacheable(value = "com.na.springboot")
    @ApiOperation("从缓存中获取user")
    public User userRedisTest(@ApiParam(value = "姓名", required = true) @RequestParam(value = "name") String name) {

        System.out.println("没有从缓存获取");
        return userService.findByName(name);
    }

    /**
     * redis session共享测试
     *
     * @param session 会话
     * @return sessionId
     */
    @GetMapping("test/redis-session")
    @ApiOperation("redis session共享测试")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    /**
     * 分页查询
     *
     * @return 分页数据
     */
    @GetMapping("page")
    @ApiOperation("分页查询")
    public List<User> pageUser(@PageableDefault(value = 8, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {

        return userService.findAll(pageable);
        // return userService.pageByName("fengna",pageable);
    }

    /**
     * 更新姓名
     *
     * @param id   主键
     * @param name 姓名
     * @return 是否更新
     */
    @PostMapping("update/{id}")
    @ApiOperation("更新姓名")
    public Boolean updateName(@PathVariable("id") Long id, @ApiParam(value = "name", required = true) @RequestParam("name") String name) {

        userService.updateByIdAndName(id, name);
        return Boolean.TRUE;
    }

    /**
     * 删除用户
     *
     * @param id 主键
     * @return 是否删除
     */
    @PostMapping("remove/{id}")
    @ApiOperation("删除用户")
    public Boolean removeUser(@PathVariable("id") Long id) {

        userService.removeById(id);
        return Boolean.TRUE;
    }
}
