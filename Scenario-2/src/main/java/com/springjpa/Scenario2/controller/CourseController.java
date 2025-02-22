package com.springjpa.Scenario2.controller;

import com.springjpa.Scenario2.model.Course;
import com.springjpa.Scenario2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courseSet = service.getAllCourses();
        return new ResponseEntity<>(courseSet, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable long courseId) {
        Course course = service.getCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> insertCourse(@RequestBody Course course) {
        Course insertCourse = service.insertCourse(course);
        return new ResponseEntity<>(insertCourse, HttpStatus.CREATED);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable long courseId) {
        Course getCourse = service.getCourseById(courseId);
        course.setId(courseId);
        Course updateCourse = service.updateCourse(course);
        return new ResponseEntity<>(updateCourse, HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable long courseId) {
        service.deleteCourse(courseId);
        return new ResponseEntity<>("Course deleted successfully!", HttpStatus.OK);
    }

}
