package com.ncu.sysweb.model;

public class User {

    private int id;
    private String jobNum;
    private String password;

    public User(int id, String jobNum, String password) {
        this.id = id;
        this.jobNum = jobNum;
        this.password = password;
    }

    public User() {

    }

    public User(User user) {
        this.id = user.id;
        this.jobNum = user.jobNum;
        this.password = user.password;
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

    public void setJobNum(String jobNUm) {
        this.jobNum = jobNUm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
