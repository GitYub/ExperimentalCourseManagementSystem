package com.ncu.sysweb.controller;

import com.ncu.sysweb.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public ArrayList<User> manageAccount(@RequestParam("role") byte role) {

    }
}
