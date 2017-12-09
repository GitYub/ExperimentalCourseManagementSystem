package com.ncu.sysweb.service;

import com.ncu.sysweb.enums.ResultEnum;
import com.ncu.sysweb.exception.UserException;
import com.ncu.sysweb.mapper.UserMapper;
import com.ncu.sysweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Map login(String jobNum, String password) throws UserException {
        User user = userMapper.getOne(jobNum);
        try {
            if (!user.getPassword().equals(password)) {
                throw new UserException(ResultEnum.JOBNUM_OR_PASSWORD_ERROR);
            }

            int role = userMapper.getRole(user.getId());

            Map mapSubject = new HashMap();
            mapSubject.put("jobNum", user.getJobNum());
            mapSubject.put("role", role);
            return mapSubject;
        } catch (NullPointerException e) {
            throw new UserException(ResultEnum.JOBNUM_OR_PASSWORD_ERROR);
        }

    }

    @Transactional
    public void modifyPWD(String jobNum, String newPWD) throws UserException {
        try {
            userMapper.modifyPWD(jobNum, newPWD);
        } catch (NullPointerException e) {
            throw new UserException(ResultEnum.MODIFYPASSWORD_ERROR);
        }

    }
}
