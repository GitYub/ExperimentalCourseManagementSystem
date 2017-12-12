package com.ncu.sysweb.service;

import com.ncu.sysweb.exception.GlobalException;
import com.ncu.sysweb.mapper.AccountMapper;
import com.ncu.sysweb.model.Account;
import com.ncu.sysweb.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    private int getRole(String jobNum) {
        return accountMapper.getRole(jobNum);
    }

    private int getCollegeId(String jobNum) {
        return accountMapper.getCollegeId(jobNum);
    }

    public ArrayList<Account> getAccountList(String jobNum) {
        int role = getRole(jobNum);

        if (role == 0) {
            return accountMapper.getListBySuperMan();
        } else if (role == 1) {
            return accountMapper.getListByDeanSOffice();
        } else if (role == 2) {
            int id_college = getCollegeId(jobNum);
            return accountMapper.getListByCollegeMan(id_college);
        }
        return null;
    }

    @Transactional
    public void delete(String jobNum) throws GlobalException {
        accountMapper.delete(jobNum);
    }

    @Transactional
    public void updateStatus(String jobNum, int status) throws GlobalException {
        accountMapper.updateStatus(jobNum, status == 0 ? 1 : 0);
    }

    public ArrayList<College> getCollege() {
        return accountMapper.getCollege();
    }

    public ArrayList getDepartment(int id_college) {
        return accountMapper.getDepartment(id_college);
    }

    @Transactional
    public void addAccount(Account account, int role) throws GlobalException {

    }
}
