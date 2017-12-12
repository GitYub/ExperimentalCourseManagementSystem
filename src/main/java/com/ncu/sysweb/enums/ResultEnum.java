package com.ncu.sysweb.enums;

public enum  ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    MODIFYPASSWORD_ERROR(402, "密码修改错误"),
    JOBNUM_OR_PASSWORD_ERROR(403, "工号或密码错误"),
    PASSWORD_TOO_LONG(405, "新密码太长")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
