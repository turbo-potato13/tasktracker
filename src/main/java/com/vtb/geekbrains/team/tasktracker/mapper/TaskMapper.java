package com.vtb.geekbrains.team.tasktracker.mapper;

import com.vtb.geekbrains.team.tasktracker.dto.CreateTaskDTO;
import com.vtb.geekbrains.team.tasktracker.dto.TaskDTO;
import com.vtb.geekbrains.team.tasktracker.entity.Project;
import com.vtb.geekbrains.team.tasktracker.entity.Task;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskMapper {

    public TaskDTO map(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .name(task.getName())
                .description(task.getDescription())
                .project(Optional.ofNullable(task.getProject()).map(Project::getId).orElse(null))
                .status(task.getStatus())
                .priority(task.getPriority())
                .createdAt(task.getCreatedAt())
                .periodOfExecution(task.getPeriodOfExecution())
                .comments(
                        task.getComments()
                                .stream()
                                .map(c -> TaskDTO.CommentDTO.builder()
                                        .id(c.getId())
                                        .content(c.getContent())
                                        .createdAt(c.getCreatedAt())
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }

    public Task map(CreateTaskDTO task) {
        final Task taskEntity = new Task();
        taskEntity.setDescription(task.getDescription());
        taskEntity.setName(task.getName());
        taskEntity.setPeriodOfExecution(task.getPeriodOfExecution());
        taskEntity.setPriority(task.getPriority());
        taskEntity.setStatus(task.getStatus());
        return taskEntity;
    }
}
