package com.vtb.geekbrains.team.tasktracker.repository;

import com.vtb.geekbrains.team.tasktracker.entity.Event;
import com.vtb.geekbrains.team.tasktracker.entity.EventType;
import com.vtb.geekbrains.team.tasktracker.entity.Project;
import com.vtb.geekbrains.team.tasktracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findAllByProjectAndTypeAndTask(Project project, EventType type, Task task);
}
