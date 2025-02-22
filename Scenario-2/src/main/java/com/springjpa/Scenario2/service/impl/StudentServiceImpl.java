package com.springjpa.Scenario2.service.impl;

import com.springjpa.Scenario2.exceptionhandler.ResourceNotFound;
import com.springjpa.Scenario2.model.Student;
import com.springjpa.Scenario2.repository.StudentRepository;
import com.springjpa.Scenario2.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentSet = repository.findAll();
        if (studentSet.isEmpty()) {
            throw new ResourceNotFound("no any student exists!");
        }
        return studentSet;
    }

    @Override
    public Student findStudentById(long id) {
        Optional<Student> student = repository.findById(id);
        if (student.isEmpty()) {
            throw new ResourceNotFound("no such student exists!");
        }
        return student.get();
    }

    @Override
    public Student insertStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        Student student = findStudentById(id);
        repository.deleteById(id);
    }
}
