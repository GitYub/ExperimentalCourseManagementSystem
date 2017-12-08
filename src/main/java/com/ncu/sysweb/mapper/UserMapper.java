package com.ncu.sysweb.mapper;

import com.ncu.sysweb.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from USER")
    List<User> getAll();


}
