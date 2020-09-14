package com.vtb.geekbrains.team.tasktracker.repository;

import com.vtb.geekbrains.team.tasktracker.entity.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @EntityGraph(attributePaths = {"project", "comments"})
    @Override
    List<Task> findAll();
}
