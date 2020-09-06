package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Project;
import com.vtb.geekbrains.team.tasktracker.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project with id " + id + " not found"));
    }

    public Project saveOrUpdate(Project project) {
        return projectRepository.save(project);
    }

    public boolean existById(Long id) {
        return projectRepository.existsById(id);
    }

    public void deleteAll() {
        projectRepository.deleteAll();
    }

    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
