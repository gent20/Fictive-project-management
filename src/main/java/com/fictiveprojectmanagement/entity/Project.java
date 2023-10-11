package com.fictiveprojectmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Project extends BaseEntity {
    private String name;

    private String description;

    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_project_id")
    @JsonIgnore
    private Project parentProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "root_project_id")
    @JsonIgnore
    private Project rootProject;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Role> allowedRoles = new HashSet<>();

    @Transient
    private List<Project> children = new ArrayList<>();

    @Transient
    private List<Task> items = new ArrayList<>();
}
