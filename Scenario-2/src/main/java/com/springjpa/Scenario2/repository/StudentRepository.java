package com.springjpa.Scenario2.repository;

import com.springjpa.Scenario2.model.Course;
import com.springjpa.Scenario2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
