package com.ncu.course.system.service;

import com.ncu.course.system.domain.Application;
import com.ncu.course.system.domain.Course;
import com.ncu.course.system.domain.User;
import com.ncu.course.system.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("ApplicationService")
public class ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    private String toBin(int timetable) {
        StringBuilder res = new StringBuilder();
        for (int i = 10; i > 0; --i) {
            if ((timetable & 1) == 1) {
                res.insert(0, i);
            }
            timetable >>= 1;
        }

        return res.toString();
    }

    @Transactional(rollbackOn = Exception.class)
    @Modifying
    public void add(int courseId, String location, int week, int day, int timetable) {

        Course course = courseService.getCourse(courseId).orElse(null);
        User user = userService.getUsername(course.getUser()).orElse(null);
        String content = user.getUsername() + "老师申请将" + course.getLocation() + "第"
                + course.getWeek() + "周，星期" + course.getDay() + "的第" + toBin(course.getTimetable()) + "节课调整到" + location
                + "第" + week + "周，星期" + day +  "的第" + toBin(timetable) + "节课";

        Application application = new Application();
        application.setContent(content);
        application.setCourse(courseId);
        application.setDay(day);
        application.setLocation(location);
        application.setTimetable(timetable);
        application.setWeek(week);
        application.setStatus(1);
        applicationRepository.save(application);

    }

    public void modify(int id, int status) {
        applicationRepository.modifyStatus(id, status);
        if (status == 0) {
            Application application = applicationRepository.findById(id).orElse(null);
            courseService.updateCourse(application.getCourse(), application.getLocation(), application.getWeek(), application.getDay(), application.getTimetable());
        }
    }

    public List<Application> list(int status) {

        return applicationRepository.findApplicationByStatus(status);

    }

    public List<Application> list(long jobNumber) {

        return applicationRepository.findApplicationByStatus(jobNumber);

    }

    public List<Application> list() {

        return applicationRepository.findApplicationByStatus();

    }
}
