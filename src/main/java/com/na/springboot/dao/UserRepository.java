package com.na.springboot.dao;

import com.na.springboot.entities.UserEntity;
import com.na.springboot.services.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 用户dao
 *
 * @author fengna
 * @date 2019/02/23 15:13
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

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


    /**
     * 按姓名分页查询
     *
     * @param name     姓名
     * @param pageable 分页
     * @return 分页数据
     */
    Page<UserEntity> findByName(String name, Pageable pageable);
}
