package com.codeclan.EmployeeDeptLab.controllers;

import com.codeclan.EmployeeDeptLab.models.Project;
import com.codeclan.EmployeeDeptLab.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
}
