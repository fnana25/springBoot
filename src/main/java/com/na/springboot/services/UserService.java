package com.na.springboot.services;

import com.na.springboot.services.models.User;

/**
 * Demo class
 *
 * @author fengna
 * @date 19/2/23 16:51
 */
public interface UserService {

    /**
     * 根据姓名查询
     * @param name 姓名
     * @return user实体
     */
    User findByName(String name);

    /**
     * 根据姓名或email查询
     * @param name 姓名
     * @param email 邮箱
     * @return user实体
     */
    User findByNameOrEmail(String name, String email);
}
