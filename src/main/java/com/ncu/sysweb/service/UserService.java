package com.ncu.sysweb.service;

import com.ncu.sysweb.enums.ResultEnum;
import com.ncu.sysweb.exception.GlobalException;
import com.ncu.sysweb.mapper.UserMapper;
import com.ncu.sysweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Map login(String jobNum, String password) throws GlobalException {
        User user = userMapper.getOne(jobNum);
        try {
            if (!user.getPassword().equals(password)) {
                throw new GlobalException(ResultEnum.JOBNUM_OR_PASSWORD_ERROR);
            }

            int role = userMapper.getRole(user.getId());

            Map mapSubject = new HashMap();
            mapSubject.put("jobNum", user.getJobNum());
            mapSubject.put("role", role);
            return mapSubject;
        } catch (NullPointerException e) {
            throw new GlobalException(ResultEnum.JOBNUM_OR_PASSWORD_ERROR);
        }
    }

    @Transactional
    public void modifyPWD(String jobNum, String newPWD) throws GlobalException {
        try {
            userMapper.modifyPWD(jobNum, newPWD);
        } catch (DataIntegrityViolationException e) {
            throw new GlobalException(ResultEnum.PASSWORD_TOO_LONG);
        }
    }
}
