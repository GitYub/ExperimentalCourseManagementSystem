package com.ncu.sysweb.controller;

import com.ncu.sysweb.model.User;
import com.ncu.sysweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public void login(@RequestParam(value = "jobNum", defaultValue = "") String jobNum, @RequestParam(value = "password", defaultValue = "") String password) {
        System.out.println("获取的数据为： " + jobNum);
        System.out.println("获取的密码为： " + password);

        User tmp = userService.login(jobNum, password);
        if (tmp != null) {
            System.out.println(tmp.getId());
            System.out.println(tmp.getJobNum());
            System.out.println(tmp.getPassword());
        }



    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifyPWD")
    public void modifyPassword(@RequestParam(value = "jobNum", defaultValue = "") String jobNum,
                              @RequestParam(value = "oldPwd", defaultValue = "") String oldPwd,
                              @RequestParam(value = "newPwd", defaultValue = "") String newPwd,
                              @RequestParam(value = "checkNew", defaultValue = "") String checkNew) {
        return ;
    }
}
