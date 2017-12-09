package com.ncu.sysweb.handle;

import com.ncu.sysweb.exception.UserException;
import com.ncu.sysweb.model.Result;
import com.ncu.sysweb.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserExceptionHandler {

    private final static Logger logger = (Logger) LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultUtils.error(userException.getCode(), userException.getMessage());
        } else {
            logger.error("【系统异常】{}", e);
            return ResultUtils.error(-1, "未知错误");
        }
    }
}
