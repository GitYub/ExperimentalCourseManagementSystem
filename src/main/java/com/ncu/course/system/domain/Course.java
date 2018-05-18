package com.ncu.course.system.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_course")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "class")
    private String schoolClass;

    @Column(name = "title")
    private String name;

    @Column
    private long user;

    @Column
    private String location;

    @Column
    private int week;

    @Column
    private int day;

    @Column
    private int timetable;

    public Course() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getTimetable() {
        return timetable;
    }

    public void setTimetable(int timetable) {
        this.timetable = timetable;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Course(int id, String schoolClass, String name, long user, String location, int week, int day, int timetable) {

        this.id = id;
        this.schoolClass = schoolClass;
        this.name = name;
        this.user = user;
        this.location = location;
        this.week = week;
        this.day = day;
        this.timetable = timetable;
    }
}
