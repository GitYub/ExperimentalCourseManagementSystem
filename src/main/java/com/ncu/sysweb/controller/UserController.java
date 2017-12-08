package com.ncu.sysweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public int login(@RequestParam(value = "name", defaultValue = "") String jobNum, @RequestParam(value = "password", defaultValue = "") String password) {

        System.out.println(jobNum);
        System.out.println(password);

        return 0;
    }
}
