package com.ncu.course.system.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_apply")
public class Application {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private String content;

    @Column
    private int status;

    @Column
    private int course;

    @Column
    private String location;

    @Column
    private int week;

    @Column
    private int day;

    @Column
    private int timetable;


    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTimetable() {
        return timetable;
    }

    public void setTimetable(int timetable) {
        this.timetable = timetable;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Application(int id, String content, int status, int course, String location, int week, int day, int timetable) {
        this.id = id;
        this.content = content;
        this.status = status;
        this.course = course;
        this.location = location;
        this.week = week;
        this.day = day;
        this.timetable = timetable;
    }

    public Application() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
