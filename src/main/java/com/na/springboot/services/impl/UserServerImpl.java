package com.na.springboot.services.impl;

import com.na.springboot.dao.UserRepository;
import com.na.springboot.entities.UserEntity;
import com.na.springboot.services.UserService;
import com.na.springboot.services.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public UserServerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        Optional<UserEntity> entityOptional = userRepository.findById(id);
        if (entityOptional.isPresent()) {
            User res = new User();
            BeanUtils.copyProperties(entityOptional.get(), res);
            return res;
        }
        return null;
    }

    @Override
    public User findByName(String name) {

        UserEntity entity = userRepository.findByName(name);
        User res = new User();
        BeanUtils.copyProperties(entity, res);
        return res;
    }

    @Override
    public User findByNameOrEmail(String name, String email) {

        UserEntity entity = userRepository.findByNameOrEmail(name, email);
        User res = new User();
        BeanUtils.copyProperties(entity, res);
        return res;
    }

    @Override
    public List<User> findAll(Pageable pageable) {

        Page<UserEntity> page = userRepository.findAll(pageable);
        List<User> res = new ArrayList<>();
        page.getContent().forEach(
                e -> res.add(new User(e.getId(), e.getName(), e.getEmail()))
        );
        return res;
    }

    @Override
    public List<User> pageByName(String name, Pageable pageable) {

        Page<UserEntity> page = userRepository.findByName(name,pageable);
        List<User> res = new ArrayList<>();
        page.getContent().forEach(
                e -> res.add(new User(e.getId(), e.getName(), e.getEmail()))
        );
        return res;
    }

    @Override
    public void updateByIdAndName(Long id, String name) {

        userRepository.updateByIdAndName(id,name);
    }

    @Override
    public void removeById(Long id) {
//11
        userRepository.removeById(id);
    }
}
