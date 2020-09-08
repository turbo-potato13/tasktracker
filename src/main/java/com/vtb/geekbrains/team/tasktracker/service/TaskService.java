package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Task;
import com.vtb.geekbrains.team.tasktracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveOrUpdate(Task task) {
        return taskRepository.save(task);
    }

    public boolean existsById(Long id) {
        return taskRepository.existsById(id);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

}
