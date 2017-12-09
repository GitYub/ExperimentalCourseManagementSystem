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

    @Select("select * from USER where jobnum = #{jobNum}")
    @Results({
            @Result(property = "id", column = "id_user"),
            @Result(property = "jobNum", column = "jobnum"),
            @Result(property = "password", column = "password")
    })
    User getOne(@Param("jobNum") String jobNum);

    @Select("select role from ROLE where id_user = #{id}")
    @Results({
            @Result(property = "role", column = "role")
    })
    int getRole(@Param("id") int id);

    @Update("update USER set password = #{password} where jobnum = #{jobNum}")
    void modifyPWD(@Param("jobNum") String jobNum, @Param("password") String password);
}
