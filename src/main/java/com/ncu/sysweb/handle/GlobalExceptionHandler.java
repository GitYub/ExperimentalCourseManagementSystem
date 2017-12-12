package com.ncu.sysweb.handle;

import com.ncu.sysweb.exception.GlobalException;
import com.ncu.sysweb.model.Result;
import com.ncu.sysweb.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return ResultUtils.error(globalException.getCode(), globalException.getMessage());
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            return ResultUtils.error(-2, "请求类型错误");
        } else {
            logger.error("【系统异常】{}", e);
            return ResultUtils.error(-1, "未知错误");
        }
    }
}
