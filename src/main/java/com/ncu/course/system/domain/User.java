package com.ncu.course.system.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    private long jobNumber;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String college;

    @Column
    private String department;

    @Column
    private int role;

    public User(long jobNumber, String username, String password, String college, String department, int role) {
        this.jobNumber = jobNumber;
        this.username = username;
        this.password = password;
        this.college = college;
        this.department = department;
        this.role = role;
    }

    public User() {

    }

    public long getJobNumber() {

        return jobNumber;
    }

    public void setJobNumber(long jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
