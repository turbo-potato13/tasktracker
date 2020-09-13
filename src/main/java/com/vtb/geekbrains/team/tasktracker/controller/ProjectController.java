package com.vtb.geekbrains.team.tasktracker.controller;

import com.vtb.geekbrains.team.tasktracker.dto.CreateTaskDTO;
import com.vtb.geekbrains.team.tasktracker.dto.TaskDTO;
import com.vtb.geekbrains.team.tasktracker.entity.Project;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import com.vtb.geekbrains.team.tasktracker.exception.ResourceNotFoundException;
import com.vtb.geekbrains.team.tasktracker.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping(produces = "application/json")
    public List<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PostMapping(produces = "application/json")
    public Project createNewProject(@RequestParam String title, Principal principal) {
        return projectService.createNewProject(title, principal.getName());
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public Project updateProject(Project project) {
        if (!projectService.existById(project.getId())) {
            throw new ResourceNotFoundException("Project with id " + project.getId() + " not found");
        }
        return projectService.saveOrUpdate(project);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id, Principal principal) {
        projectService.deleteById(id, principal.getName());
    }

    @PutMapping("/{id}/{login}")
    public User addMemberToProject(@PathVariable Long id, @PathVariable String login) {
        return projectService.addMember(id, login);
    }

    @DeleteMapping("/{id}/{login}")
    public void deleteMemberFromProject(@PathVariable Long id, @PathVariable String login) {
        projectService.deleteMember(id, login);
    }

    @PutMapping("/{id}/members")
    public Project addTaskToProject(@PathVariable Long id, Principal principal, @RequestBody CreateTaskDTO task) {
        return projectService.addTask(id, principal.getName(), task);
    }
}
