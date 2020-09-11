package com.vtb.geekbrains.team.tasktracker.controller;

import com.vtb.geekbrains.team.tasktracker.dto.CreateTaskDTO;
import com.vtb.geekbrains.team.tasktracker.dto.TaskDTO;
import com.vtb.geekbrains.team.tasktracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskDTO> getAllDocuments() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO createNewTask(@RequestBody CreateTaskDTO task) {
        return taskService.create(task);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public TaskDTO modifyTask(@RequestBody CreateTaskDTO task) {
        return taskService.create(task);
    }

    @DeleteMapping
    public void deleteAllTasks() {
        taskService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
    }

}
