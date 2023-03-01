package com.kagami.service.impl;


import com.kagami.pojo.User;
import com.kagami.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public User userInfo() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        return user;
    }
}