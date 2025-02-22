package com.springjpa.Scenario1.controller;

import com.springjpa.Scenario1.exceptionhanlder.ResourceNotFound;
import com.springjpa.Scenario1.model.Department;
import com.springjpa.Scenario1.model.Employee;
import com.springjpa.Scenario1.service.DepartmentService;
import com.springjpa.Scenario1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{departId}/employees")
    public ResponseEntity<List<Employee>> getAllEmployeesOfDepartment(@PathVariable long departId) {
        Department getDepartment = departmentService.findDepartmentById(departId);
        List<Employee> employeeList = getDepartment.getEmployeeList();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/{departId}/employees/{employId}")
    public ResponseEntity<Employee> getEmployeeOfDepartment(@PathVariable long departId, @PathVariable long employId) {
        Department getDepartment = departmentService.findDepartmentById(departId);
        List<Employee> getEmployee = getDepartment.getEmployeeList();
        for (Employee e : getEmployee) {
            if (e.getId() == employId){
                return new ResponseEntity<>(e, HttpStatus.OK);
            }
        }
        return ResponseEntity.notFound().build();
    }

//    Similarly you can untilize Delete, Update and Insert controllers and your application APIS get completed


}
