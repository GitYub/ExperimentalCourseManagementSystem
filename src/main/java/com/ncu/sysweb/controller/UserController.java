package com.ncu.sysweb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ncu.sysweb.error.UserDefinedException;
import com.ncu.sysweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Map login(@RequestParam(value = "jobNum", defaultValue = "") String jobNum, @RequestParam(value = "password", defaultValue = "") String password) throws UserDefinedException, JsonProcessingException {
        System.out.println("获取的数据为： " + jobNum);
        System.out.println("获取的密码为： " + password);

        return userService.login(jobNum, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifyPWD")
    public void modifyPassword(@RequestParam(value = "jobNum", defaultValue = "") String jobNum,
                              @RequestParam(value = "newPwd", defaultValue = "") String newPwd) {
        userService.modifyPWD(jobNum, newPwd);
    }
}
