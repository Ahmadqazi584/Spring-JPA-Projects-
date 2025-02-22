package com.springjpa.Scenario1.service;

import com.springjpa.Scenario1.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();
    Department findDepartmentById(long id);
    Department insertDepartment(Department department);
    Department updateDepartment(Department department);
    Department deleteDepartment(long id);

}
