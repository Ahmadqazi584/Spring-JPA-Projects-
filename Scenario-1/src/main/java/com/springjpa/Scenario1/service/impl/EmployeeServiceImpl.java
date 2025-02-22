package com.springjpa.Scenario1.service.impl;

import com.springjpa.Scenario1.exceptionhanlder.ResourceNotFound;
import com.springjpa.Scenario1.model.Employee;
import com.springjpa.Scenario1.repository.EmployeeRepository;
import com.springjpa.Scenario1.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = repository.findAll();
        if (employeeList.isEmpty()) {
            throw new ResourceNotFound("no any employee exists!");
        }
        return employeeList;
    }

    @Override
    public Employee findEmployeeById(long id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isEmpty()) {
            throw new ResourceNotFound("no such employee exists!");
        }
        return employee.get();
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee deleteEmployee(long id) {
        Employee employee = findEmployeeById(id);
        repository.deleteById(id);
        return employee;
    }
}
