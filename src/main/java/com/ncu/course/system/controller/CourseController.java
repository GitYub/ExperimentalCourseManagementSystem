package com.ncu.course.system.controller;

import com.ncu.course.system.service.CourseService;
import com.ncu.course.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/sys/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/upload")
    public ReturnUtil uploadTimeTable(@RequestParam("file") MultipartFile file) {
        courseService.save(file);
        return new ReturnUtil(null, 0);
    }

    @GetMapping("/list")
    public ReturnUtil getCourse(@RequestParam("jobNumber") long jobNumber) {
        return new ReturnUtil(courseService.getCourse(jobNumber), 0);
    }

    @PostMapping("/apply")
    public ReturnUtil apply(@RequestParam("id") int id, @RequestParam("location") String location, @RequestParam("week") int week, @RequestParam("day") int day, @RequestParam("timetable") int time) {
        boolean isSuccess = courseService.submitApplication(id, location, week, day, time);
        return new ReturnUtil(null, isSuccess ? 0 : 1);
    }
}
