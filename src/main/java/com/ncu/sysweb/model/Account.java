package com.ncu.sysweb.model;

public class Account {

    private int id;

    private String jobNum;

    private String userName;

    private String college;

    private String department;

    private short status;

    public Account() {}

    public Account(int id, String jobNum, String userName, String college, String department, short status) {
        this.id = id;
        this.jobNum = jobNum;
        this.userName = userName;
        this.college = college;
        this.department = department;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
