package com.ncu.sysweb.enums;

public enum FileHeaderEnum {
    XLSX("504B0304"),
    XLS("D0CF11E0")
    ;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    FileHeaderEnum(String code) {
        this.code = code;
    }
}
