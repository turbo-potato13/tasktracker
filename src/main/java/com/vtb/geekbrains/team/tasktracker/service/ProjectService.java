package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Project;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import com.vtb.geekbrains.team.tasktracker.exception.ResourceNotFoundException;
import com.vtb.geekbrains.team.tasktracker.repository.ProjectRepository;
import com.vtb.geekbrains.team.tasktracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

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

    public Project createNewProject(String title) {
        Project project = new Project();
        project.setTitle(title);
        return projectRepository.save(project);
    }

    public User addMember(Long id, String login) {
        User user = userRepository.findByName(login)
                .orElseThrow(() -> new ResourceNotFoundException("User not found. Login: " + login));
        Project project = projectRepository.findById(id).get();
        project.getMembers().add(user);
        projectRepository.save(project);
        return user;
    }

    public void deleteMember(Long id, String login) {
        User user = userRepository.findByName(login)
                .orElseThrow(() -> new ResourceNotFoundException("User not found. Login: " + login));
        Project project = projectRepository.findById(id).get();
        project.getMembers().remove(user);
        projectRepository.save(project);
    }
}
