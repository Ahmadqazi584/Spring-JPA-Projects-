package com.springjpa.Scenario1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Scenario1Application {

	public static void main(String[] args) {
		SpringApplication.run(Scenario1Application.class, args);
	}

}

//Scenario 1: Employee & Department Management System
//Your company needs a system to manage employees and departments.
//
//Each employee has an id, name, email, and salary.
//A department has an id, name, and location.
//An employee belongs to a department.
//A department can have multiple employees.
//Implement a REST API to fetch:
//All employees in a department.
//An employee’s department details.
