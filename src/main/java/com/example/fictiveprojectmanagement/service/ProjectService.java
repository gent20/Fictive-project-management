package com.example.fictiveprojectmanagement.service;

import com.example.fictiveprojectmanagement.entity.Project;
import com.example.fictiveprojectmanagement.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(){
        List<Project> rootProjects = projectRepository.findAllRoots(); // first db call

        // Now Find all the subcategories
        List<Long> rootProjectIds = rootProjects.stream().map(Project::getId).toList();
        List<Project> subProjects = projectRepository.findAllSubCategoriesInRoot(rootProjectIds); // second db call

        subProjects.forEach(subCategory ->
                subCategory.getParentProject().getChildren().add(subCategory)); // no further db call, because everyone inside the root is in the persistence context.

        return rootProjects;
    }
}

