package com.na.springboot.entities;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 用户实体
 *
 * @author fengna
 * @date 19/2/23 15:06
 */
@Entity
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -1715052174602368831L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 姓名
     */
    @Column(unique = true)
    private String name;

    /**
     * 邮箱
     */
    @Column(nullable = false,unique = true)
    private String email;

}
