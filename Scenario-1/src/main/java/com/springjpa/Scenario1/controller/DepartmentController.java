package com.springjpa.Scenario1.controller;

import com.springjpa.Scenario1.exceptionhanlder.ResourceNotFound;
import com.springjpa.Scenario1.model.Department;
import com.springjpa.Scenario1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departmentList = service.getAllDepartments();
        return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }

    @GetMapping("/{departId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable long departId) {
        Department department = service.findDepartmentById(departId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> insertDepartment(@RequestBody Department department) {
        Department department1 = service.insertDepartment(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }

    @PutMapping("/{departId}")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable long departId) {
        Department department1 = service.findDepartmentById(departId);
        department.setId(departId);
        Department updateDepartment = service.updateDepartment(department);
        return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
    }

    @DeleteMapping("/{departId}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable long departId) {
        Department deleteDepartment = service.deleteDepartment(departId);
        return new ResponseEntity<>(deleteDepartment, HttpStatus.OK);
    }

}
