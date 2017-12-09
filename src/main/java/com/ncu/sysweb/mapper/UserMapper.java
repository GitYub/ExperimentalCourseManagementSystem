package com.ncu.sysweb.mapper;

import com.ncu.sysweb.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface UserMapper {

    @Select("select * from USER")
    @Results({
            @Result(property = "id", column = "id_user"),
            @Result(property = "jobNum", column = "jobnum"),
            @Result(property = "password", column = "password")
    })
    List<User> getAll();

    @Select("select * from USER where password = #{password} and jobnum = #{jobnum}")
    @Results({
            @Result(property = "id", column = "id_user"),
            @Result(property = "jobNum", column = "jobnum"),
            @Result(property = "password", column = "password")
    })
    User getOne(@Param("jobnum") String jobnum, @Param("password") String password);



}
