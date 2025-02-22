package com.springjpa.Scenario1.service;

import com.springjpa.Scenario1.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee findEmployeeById(long id);
    Employee insertEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee deleteEmployee(long id);
}
