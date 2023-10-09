package com.example.fictiveprojectmanagement.entity;

import com.example.fictiveprojectmanagement.model.Priority;
import com.example.fictiveprojectmanagement.model.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column
    private Type type;

    private String text;

    private String url;

    private String title;

    private int order;

    @Enumerated(EnumType.STRING)
    @Column
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    @JsonIgnore
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    @JsonIgnore
    private User assignee;
}
