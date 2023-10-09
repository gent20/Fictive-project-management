package com.example.fictiveprojectmanagement.controller;

import com.example.fictiveprojectmanagement.entity.Project;
import com.example.fictiveprojectmanagement.service.ProjectService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects/all")
    @Transactional
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
}