package com.ncu.sysweb.controller;

import com.ncu.sysweb.exception.GlobalException;
import com.ncu.sysweb.model.Result;
import com.ncu.sysweb.model.Xls;
import com.ncu.sysweb.service.CurriculumService;
import com.ncu.sysweb.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @PostMapping("/upload")
    public Result<Xls> upload(@RequestParam("file") MultipartFile file) throws GlobalException {
        curriculumService.upload(file);
        return ResultUtils.success();
    }
}
