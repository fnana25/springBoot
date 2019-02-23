package com.na.springboot.controller.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User
 *
 * @author fengna
 * @date 19/2/23 08:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -5386788020491681182L;

    private String name;

    private String email;
}
