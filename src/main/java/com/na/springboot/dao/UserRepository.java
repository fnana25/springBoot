package com.na.springboot.dao;

import com.na.springboot.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户dao
 *
 * @author fengna
 * @date 2019/02/23 15:13
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * 根据姓名查询
     *
     * @param name 姓名
     * @return user实体
     */
    UserEntity findByName(String name);

    /**
     * 根据姓名或email查询
     *
     * @param name  姓名
     * @param email 邮箱
     * @return user实体
     */
    UserEntity findByNameOrEmail(String name, String email);
}
