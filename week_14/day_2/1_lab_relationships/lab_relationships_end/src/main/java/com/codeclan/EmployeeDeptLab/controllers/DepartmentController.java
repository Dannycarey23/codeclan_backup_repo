package com.codeclan.EmployeeDeptLab.controllers;

import com.codeclan.EmployeeDeptLab.models.Department;
import com.codeclan.EmployeeDeptLab.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
