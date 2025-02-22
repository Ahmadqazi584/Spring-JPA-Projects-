package com.springjpa.Scenario2.service.impl;

import com.springjpa.Scenario2.exceptionhandler.ResourceNotFound;
import com.springjpa.Scenario2.model.Course;
import com.springjpa.Scenario2.repository.CourseRepository;
import com.springjpa.Scenario2.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public List<Course> getAllCourses() {
        List<Course> courseSet = repository.findAll();
        if (courseSet.isEmpty()) {
            throw new ResourceNotFound("no any course exists");
        }
        return courseSet;
    }

    @Override
    public Course getCourseById(long id) {
        Optional<Course> course = repository.findById(id);
        if (course.isEmpty()){
            throw new ResourceNotFound("not such course exists!");
        }
        return course.get();
    }

    @Override
    public Course insertCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public void deleteCourse(long id) {
        Course course = getCourseById(id); // Ensure the course exists
        repository.delete(course); // Use delete(entity) instead of deleteById(id)
    }

}
