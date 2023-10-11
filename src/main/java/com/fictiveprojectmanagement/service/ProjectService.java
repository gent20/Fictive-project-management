package com.fictiveprojectmanagement.service;

import com.fictiveprojectmanagement.entity.Project;
import com.fictiveprojectmanagement.entity.Role;
import com.fictiveprojectmanagement.repository.ProjectRepository;
import com.fictiveprojectmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public List<Project> getAllProjects() {
        List<Project> rootProjects = projectRepository.findAllRoots();
        rootProjects.forEach(project -> project.setItems(taskRepository.findTaskByProject(project.getId())));

        List<Long> rootProjectIds = rootProjects.stream().map(Project::getId).toList();
        List<Project> subProjects = projectRepository.findAllSubProjectsInRoot(rootProjectIds);

        subProjects.forEach(subProject -> subProject.setItems((taskRepository.findTaskByProject(subProject.getId()))));
        subProjects.forEach(subCategory -> subCategory.getParentProject().getChildren().add(subCategory));

        return rootProjects;
    }

    public void assignRoleToProject(Project project, Role role) {
        project.getAllowedRoles().add(role);
        projectRepository.save(project);
    }
}

