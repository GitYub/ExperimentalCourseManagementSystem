package com.ncu.course.util;

import java.util.HashMap;

public class ReturnUtil extends HashMap<String, Object> {

    public ReturnUtil(Object data, int code) {
        put("data", data);
        put("code", code);
    }

}
