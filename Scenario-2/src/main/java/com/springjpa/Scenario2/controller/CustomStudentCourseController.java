package com.springjpa.Scenario2.controller;

import com.springjpa.Scenario2.model.Course;
import com.springjpa.Scenario2.model.Student;
import com.springjpa.Scenario2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CustomStudentCourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{courseId}/enrolled")
    public ResponseEntity<List<Student>> getAllStudentsOfCourse(@PathVariable long courseId) {
        Course course = courseService.getCourseById(courseId);
        List<Student> studentList = course.getStudentSet();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/{courseId}/enrolled/{studentId}")
    public ResponseEntity<Student> getAllStudentsOfCourse(@PathVariable long courseId, @PathVariable long studentId) {
        Course course = courseService.getCourseById(courseId);
        List<Student> studentList = course.getStudentSet();
        for (Student s : studentList) {
            if (s.getId() == studentId) {
                return new ResponseEntity<>(s, HttpStatus.OK);
            }
        }
        return ResponseEntity.notFound().build();
    }

}
