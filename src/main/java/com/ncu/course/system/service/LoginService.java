package com.ncu.course.system.service;

import com.ncu.course.system.domain.User;
import com.ncu.course.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("LoginService")
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public User login(long jobNumber, String password) {
        return userRepository.findUserByJobNumberAndPassword(jobNumber, password).orElse(null);
    }
}
