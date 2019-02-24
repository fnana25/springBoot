package com.na.springboot.services.impl;

import com.na.springboot.dao.UserRepository;
import com.na.springboot.services.UserService;
import com.na.springboot.services.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务
 *
 * @author fengna
 * @date 19/2/23 16:54
 */
@Service
@Slf4j
public class UserServerImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServerImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findByName(String name) {

        userRepository.findByName(name);
        return null;
    }

    @Override
    public User findByNameOrEmail(String name, String email) {

        userRepository.findByNameOrEmail(name,email);
        return null;
    }
}
