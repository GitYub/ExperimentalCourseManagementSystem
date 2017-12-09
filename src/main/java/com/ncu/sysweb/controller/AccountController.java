package com.ncu.sysweb.controller;

import com.ncu.sysweb.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @PostMapping(value = "/list")
    public ArrayList<User> manageAccount(@RequestParam("role") byte role) {
        return  null;
    }
}
