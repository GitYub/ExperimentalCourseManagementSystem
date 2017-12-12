package com.ncu.sysweb.controller;

import com.ncu.sysweb.exception.GlobalException;
import com.ncu.sysweb.model.*;
import com.ncu.sysweb.service.AccountService;
import com.ncu.sysweb.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/account")
    public Result<Account> manageAccount(@RequestParam("jobNum") String jobNum) {
        return ResultUtils.success(accountService.getAccountList(jobNum));
    }

    @DeleteMapping(value = "/account/{jobNum}")
    public Result<Account> deleteAccount(@PathVariable("jobNum") String jobNum) throws GlobalException {
        accountService.delete(jobNum);
        return ResultUtils.success();
    }

    @PutMapping(value = "/account/{jobNum}/{status}")
    public Result<Account> updateAccountStatus(@PathVariable("jobNum") String jobNum, @PathVariable("status") int status) throws GlobalException {
        accountService.updateStatus(jobNum, status);
        return ResultUtils.success();
    }

    @GetMapping(value = "/account/college")
    public Result<College> getCollege() {
        return ResultUtils.success(accountService.getCollege());
    }

    @GetMapping(value = "/account/department/{id_college}")
    public Result<Department> getDepartment(@PathVariable("id_college") int id) {
        return ResultUtils.success(accountService.getDepartment(id));
    }

    @PostMapping(value = "/account/{role}")
    public Result<Account> addAccount(@PathVariable("role") int role, @RequestBody Account account) throws GlobalException {
        //accountService.
        return ResultUtils.success();
    }

}
