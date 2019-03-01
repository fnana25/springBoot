package com.na.springboot.dao;

import com.na.springboot.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 根据id和姓名修改
     *
     * @param id   主键
     * @param name 姓名
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("update UserEntity u set u.name = ?2 where u.id = ?1")
    void updateByIdAndName(Long id, String name);

    /**
     * 根据id删除
     *
     * @param id 主键
     */
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("delete from UserEntity where id = ?1")
    void removeById(Long id);

}
