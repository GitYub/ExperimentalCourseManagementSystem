package com.ncu.course.system.controller;

import com.ncu.course.system.service.ApplicationService;
import com.ncu.course.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/application")
public class ApplicationController {
    
    @Autowired
    ApplicationService applicationService;

    @PutMapping("/modify")
    public ReturnUtil modify(@RequestParam("id") int id, @RequestParam("status") int status) {
        applicationService.modify(id, status);
        return new ReturnUtil(null, 0);
    }

    @GetMapping("/list")
    public ReturnUtil list(@RequestParam("status") int status) {
        return new ReturnUtil(applicationService.list(status), 0);
    }

    @GetMapping("/list_by_user")
    public ReturnUtil list(@RequestParam("jobNumber") long jobNumber) {
        return new ReturnUtil(applicationService.list(jobNumber), 0);
    }

    @GetMapping("/list_is_checked")
    public ReturnUtil list() {
        return new ReturnUtil(applicationService.list(), 0);
    }
}
