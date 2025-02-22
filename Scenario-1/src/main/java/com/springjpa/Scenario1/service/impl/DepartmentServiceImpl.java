package com.springjpa.Scenario1.service.impl;

import com.springjpa.Scenario1.exceptionhanlder.ResourceNotFound;
import com.springjpa.Scenario1.model.Department;
import com.springjpa.Scenario1.repository.DepartmentRepository;
import com.springjpa.Scenario1.service.DepartmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departmentList = repository.findAll();
        if (departmentList.isEmpty()) {
            throw new ResourceNotFound("no any department exists!");
        }
        return departmentList;
    }

    @Override
    public Department findDepartmentById(long id) {
        Optional<Department> department = repository.findById(id);
        if (department.isEmpty()) {
            throw new ResourceNotFound("no such department exists!");
        }
        return department.get();
    }

    @Override
    public Department insertDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    @Transactional
    public Department deleteDepartment(long id) {
        Department getDepartment = findDepartmentById(id);
        repository.deleteById(id);
        return getDepartment;
    }
}
