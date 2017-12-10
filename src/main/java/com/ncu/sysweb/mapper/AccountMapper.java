package com.ncu.sysweb.mapper;

import com.ncu.sysweb.model.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface AccountMapper {

    /**
     * 0:超级管理员
     * 1：教务处管理员
     * 2：学院管理员
     * 3：系管理员
     * 4：普通老师
     * */

    @Select("select id_user, jobnum, username, '教务处管理员' college, '教务处管理员' department, status from user " +
            "where id_user in (SELECT id_user from role where role = 1)")
    @Results({
            @Result(property = "id",column = "id_user"),
            @Result(property = "jobNum", column = "jobnum"),
            @Result(property = "userName", column = "username"),
            @Result(property = "college", column = "college"),
            @Result(property = "department", column = "department"),
            @Result(property = "status", column = "status")
    })
    ArrayList<Account> getListBySuperMan();

    @Select("select id_user, jobnum, username, co.name college, '学院管理员' department, status from user LEFT JOIN " +
            "college co on id_college = co.id where id_user in (SELECT id_user from role where role = 2)")
    @Results({
            @Result(property = "id",column = "id_user"),
            @Result(property = "jobNum", column = "jobnum"),
            @Result(property = "userName", column = "username"),
            @Result(property = "college", column = "college"),
            @Result(property = "department", column = "department"),
            @Result(property = "status", column = "status")
    })
    ArrayList<Account> getListByDeanSOffice();

    @Select("select id_user, jobnum, username, co.name college, de.name department, status from user LEFT JOIN " +
            "college co on id_college = co.id  LEFT JOIN department de on id_department = de.id " +
            "where id_user in (SELECT id_user from role where role = 3) " +
            "and id_college = #{id_college}")
    @Results({
            @Result(property = "id",column = "id_user"),
            @Result(property = "jobNum", column = "jobnum"),
            @Result(property = "userName", column = "username"),
            @Result(property = "college", column = "college"),
            @Result(property = "department", column = "department"),
            @Result(property = "status", column = "status")
    })
    ArrayList<Account> getListByCollegeMan(@Param("id_college") int id_college);

    @Select("select role from role where id_user in (select id_user from user where jobnum = #{jobNum})")
    @Results({
            @Result(property = "role", column = "role")
    })
    int getRole(@Param("jobNum") String jobNum);

    @Select("select id_college from user where jobnum = #{jobNum}")
    @Results({
            @Result(property = "id_college", column = "id_college")
    })
    int getCollegeId(@Param("jobNum") String jobNum);

    @Delete("delete from user where jobnum = #{jobNum}")
    void delete(@Param("jobNum") String jobNum);

    @Update("update user set status = #{status} where jobnum = #{jobNum}")
    void updateStatus(@Param("jobNum") String jobNum, @Param("status") int status);
}
