package com.fictiveprojectmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
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

    @Transient
    private List<Project> children = new ArrayList<>();

    @Transient
    private List<Task> items = new ArrayList<>();
}
