package com.ncu.sysweb.controller;

import com.ncu.sysweb.exception.UserException;
import com.ncu.sysweb.model.Result;
import com.ncu.sysweb.model.User;
import com.ncu.sysweb.service.UserService;
import com.ncu.sysweb.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public Result<User> login(@RequestParam(value = "jobNum", defaultValue = "") String jobNum,
                              @RequestParam(value = "password", defaultValue = "") String password) throws UserException {

        return ResultUtils.success(userService.login(jobNum, password));
    }

    @PostMapping(value = "/modifyPwd")
    public Result<User> modifyPassword(@RequestParam(value = "jobNum", defaultValue = "") String jobNum,
                              @RequestParam(value = "newPwd", defaultValue = "") String newPwd) throws UserException {

        userService.modifyPWD(jobNum, newPwd);
        return ResultUtils.success();
    }
}
