package com.fictiveprojectmanagement.repository;

import com.fictiveprojectmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT task FROM Task task "
            + " WHERE task.project.id = :id")
    List<Task> findTaskByProject(@RequestParam Long id);

}
