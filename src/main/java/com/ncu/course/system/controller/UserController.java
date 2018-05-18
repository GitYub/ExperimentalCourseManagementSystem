package com.ncu.course.system.controller;

import com.google.gson.Gson;
import com.ncu.course.system.domain.User;
import com.ncu.course.system.service.UserService;
import com.ncu.course.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/remove")
    public ReturnUtil removeUser(@RequestParam("jobNumber") long jobNumber) {

        try {
            userService.remove(jobNumber);
        } catch (Exception e) {
            return new ReturnUtil(null, 1);
        }

        return new ReturnUtil(null, 0);

    }

    @PostMapping("/add")
    public ReturnUtil addUser(@RequestBody String data) {

        Gson gson = new Gson();
        User user = gson.fromJson(data, User.class);
        userService.add(user);
        return new ReturnUtil(null, 0);

    }

    @GetMapping("/list")
    public ReturnUtil list() {
        return new ReturnUtil(userService.list(), 0);
    }

    @PutMapping("/modify_password")
    public ReturnUtil modifyPassword(@RequestParam("jobNumber") long jobNumber, @RequestParam("password") String password) {
        userService.modifyPwd(jobNumber, password);
        return new ReturnUtil(null, 0);
    }

}