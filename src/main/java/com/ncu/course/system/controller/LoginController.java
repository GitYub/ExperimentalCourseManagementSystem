package com.ncu.course.system.controller;

import com.ncu.course.system.domain.User;
import com.ncu.course.system.service.LoginService;
import com.ncu.course.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ResponseBody
    public ReturnUtil login(@RequestParam("jobNumber") long jobNumber, @RequestParam("password") String password) {
        Optional<User> user = Optional.ofNullable(loginService.login(jobNumber, password));
        return user.map(user1 -> new ReturnUtil(user1, 0)).orElseGet(() -> new ReturnUtil(null, 1));
    }

}
