package com.springjpa.Scenario2.controller;

import com.springjpa.Scenario2.model.Student;
import com.springjpa.Scenario2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentSet = service.getAllStudents();
        return new ResponseEntity<>(studentSet, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable long studentId) {
        Student student = service.findStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        Student insertStudent = service.insertStudent(student);
        return new ResponseEntity<>(insertStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable long studentId) {
        Student getStudent = service.findStudentById(studentId);
        student.setId(studentId);
        Student updateStudent = service.updateStudent(student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable long studentId) {
        service.deleteStudent(studentId);
        return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
    }


}
