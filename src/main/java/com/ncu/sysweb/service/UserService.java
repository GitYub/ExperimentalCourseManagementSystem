package com.ncu.sysweb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ncu.sysweb.error.UserDefinedException;
import com.ncu.sysweb.mapper.UserMapper;
import com.ncu.sysweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Map login(String jobNum, String password) throws UserDefinedException {
        User user = userMapper.getOne(jobNum);
        try {
            if (!user.getPassword().equals(password)) {
                throw new UserDefinedException("工号或密码错误", 403);
            }

            int role = userMapper.getRole(user.getId());

            Map mapSubject = new HashMap();
            mapSubject.put("jobNum", user.getJobNum());
            mapSubject.put("role", role);
            return mapSubject;
        } catch (NullPointerException e) {
            throw new UserDefinedException("工号或密码错误", 403);
        }

    }

    public void modifyPWD(String jobNum, String newPWD) {
        userMapper.modifyPWD(jobNum, newPWD);
    }
}
