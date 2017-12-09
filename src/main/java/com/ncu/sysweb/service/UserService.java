package com.ncu.sysweb.service;

import com.ncu.sysweb.mapper.UserMapper;
import com.ncu.sysweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String jobNum, String password) {
        return userMapper.getOne(jobNum, password);
    }
}
