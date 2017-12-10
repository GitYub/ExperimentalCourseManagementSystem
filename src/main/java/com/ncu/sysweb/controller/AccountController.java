package com.ncu.sysweb.controller;

import com.ncu.sysweb.model.Account;
import com.ncu.sysweb.model.Result;
import com.ncu.sysweb.model.User;
import com.ncu.sysweb.service.AccountService;
import com.ncu.sysweb.util.ResultUtils;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/account")
    public Result<Account> manageAccount(@RequestParam("jobNum") String jobNum) {
        return ResultUtils.success(accountService.getAccountList(jobNum));
    }

    @DeleteMapping(value = "/account/{jobNum}")
    public Result<Account> deleteAccount(@PathVariable("jobNum") String jobNum) {
        accountService.delete(jobNum);
        return ResultUtils.success();
    }

    @PostMapping(value = "/account/{jobNum}/{status}")
    public Result<Account> updateAccountStatus(@PathVariable("jobNum") String jobNum, @PathVariable("status") int status) {
        System.out.println(jobNum);
        System.out.println(status);

        accountService.updateStatus(jobNum, status);
        return ResultUtils.success();
    }
}
