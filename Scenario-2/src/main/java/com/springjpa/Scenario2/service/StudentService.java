package com.springjpa.Scenario2.service;

import com.springjpa.Scenario2.model.Student;

import java.util.List;
import java.util.Set;

public interface StudentService {

    List<Student> getAllStudents();
    Student findStudentById(long id);
    Student insertStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(long id);

}
