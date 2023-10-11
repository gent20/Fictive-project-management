package com.fictiveprojectmanagement.controller;

import com.fictiveprojectmanagement.entity.Project;
import com.fictiveprojectmanagement.model.LoginDto;
import com.fictiveprojectmanagement.service.ProjectService;
import com.fictiveprojectmanagement.service.UserDetail;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService projectService;
    private final AuthenticationManager authenticationManager;

    public ProjectController(ProjectService projectService, AuthenticationManager authenticationManager) {
        this.projectService = projectService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/projects/all")
    @Transactional
    public List<Project> getAllProjects(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return projectService.getAllProjects();
    }
}