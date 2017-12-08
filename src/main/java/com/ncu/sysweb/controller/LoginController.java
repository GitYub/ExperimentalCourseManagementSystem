package com.ncu.sysweb.controller;

import com.ncu.sysweb.entity.UserEntity;
import com.ncu.sysweb.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class LoginController {

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public int login(@RequestParam(value = "name", defaultValue = "") String jobNum, @RequestParam(value = "password", defaultValue = "") String password) {

        List<UserEntity> userEntityList = new UserMapper() {
            @Override
            public List<UserEntity> getAll() {
                return null;
            }
        }.getAll();
        System.out.println(jobNum);
        System.out.println(password);

        return 0;
    }
}
