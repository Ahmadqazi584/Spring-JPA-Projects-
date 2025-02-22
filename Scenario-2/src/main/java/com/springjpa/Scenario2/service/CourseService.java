package com.springjpa.Scenario2.service;

import com.springjpa.Scenario2.model.Course;

import java.util.List;
import java.util.Set;

public interface CourseService {

    List<Course> getAllCourses();
    Course getCourseById(long id);
    Course insertCourse(Course course);
    Course updateCourse(Course course);
    void deleteCourse(long id);
}
