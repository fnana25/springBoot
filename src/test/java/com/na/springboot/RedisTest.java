package com.na.springboot;

import com.na.springboot.services.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * re
 *
 * @author fengna
 * @date 2019/2/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testString() {
        stringRedisTemplate.opsForValue().set("name", "fengna");
        Assert.assertEquals("fengna", stringRedisTemplate.opsForValue().get("name"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User(3L, "fengna", "692098869@qq.com");
        redisTemplate.opsForValue().set("com.na.springboot", user);
        redisTemplate.opsForValue().set("com.na.springboot.f", user, 10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        Boolean exists = redisTemplate.hasKey("com.na.springboot.f");
        if (null != exists && exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }
}
