package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.dto.CreateCommentDto;
import com.vtb.geekbrains.team.tasktracker.dto.CreateTaskDTO;
import com.vtb.geekbrains.team.tasktracker.dto.TaskDTO;
import com.vtb.geekbrains.team.tasktracker.entity.Comment;
import com.vtb.geekbrains.team.tasktracker.entity.Task;
import com.vtb.geekbrains.team.tasktracker.exception.ResourceNotFoundException;
import com.vtb.geekbrains.team.tasktracker.mapper.TaskMapper;
import com.vtb.geekbrains.team.tasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public List<TaskDTO> findAll() {
        return taskRepository.findAll().stream()
                .map(taskMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<TaskDTO> findById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::map);
    }

    public Optional<Task> findEntityById(Long id){
        return taskRepository.findById(id);
    }

    public TaskDTO create(CreateTaskDTO task) {
        return Optional.of(task)
                .map(taskMapper::map)
                .map(taskRepository::save)
                .map(taskMapper::map)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Comment addCommentToTask(CreateCommentDto comment){
        Comment commentEntity = new Comment();
        commentEntity.setContent(comment.getContent());
        commentEntity.setTask(taskRepository.findById(comment.getTask()).get());
        return commentEntity;
    }
}
