package com.ncu.course.system.repository;

import com.ncu.course.system.domain.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    @Query(value = "select * from t_course where user = ?1", nativeQuery = true)
    List<Course> findCourseByUser(long jobNumber);

    @Query(value = "select count(*) from t_course where location = ?1 and week = ?2 and day = ?3 and timetable & ?4 >= 1", nativeQuery = true)
    long countCourseByLocationAndWeekAndDayAndTimetable(String location, int week, int day, int timetable);

    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query(value = "update t_course set location = ?2, week = ?3, day = ?4, timetable = ?5 where id = ?1", nativeQuery = true)
    void updateCourse(int id, String location, int week, int day, int timetable);
}
