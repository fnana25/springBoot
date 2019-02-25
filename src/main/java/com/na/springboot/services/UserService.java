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
     * 根据主键查找
     *
     * @param id 主键
     * @return user
     */
    User findById(Long id);

    /**
     * 根据姓名查询
     *
     * @param name 姓名
     * @return user
     */
    User findByName(String name);

    /**
     * 根据姓名或email查询
     *
     * @param name  姓名
     * @param email 邮箱
     * @return user
     */
    User findByNameOrEmail(String name, String email);
}
