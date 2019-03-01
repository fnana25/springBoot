package com.na.springboot.services;

import com.na.springboot.services.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户服务
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

    /**
     * 分页查询
     *
     * @param pageable 分页
     * @return 分页数据
     */
    List<User> findAll(Pageable pageable);

    /**
     * 按姓名分页查询
     *
     * @param name     姓名
     * @param pageable 分页
     * @return 分页数据
     */
    List<User> pageByName(String name, Pageable pageable);

    /**
     * 自定义sql更新
     *
     * @param id   主键
     * @param name 姓名
     */
    void updateByIdAndName(Long id, String name);

    /**
     * 根据id删除
     *
     * @param id 主键
     */
    void removeById(Long id);

}
