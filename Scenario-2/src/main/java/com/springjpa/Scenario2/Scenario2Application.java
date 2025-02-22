package com.springjpa.Scenario2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Scenario2Application {

	public static void main(String[] args) {
		SpringApplication.run(Scenario2Application.class, args);
	}

}

//Scenario 2: Online Course Platform
//An online platform needs to track students and courses.
//
//A student has an id, name, email, and enrollmentDate.
//A course has an id, title, description, and duration.
//A student can enroll in multiple courses, and a course can have multiple students.
//Implement API endpoints to:
//Enroll a student in a course.
//Fetch all students in a course.
//Fetch all courses a student is enrolled in.