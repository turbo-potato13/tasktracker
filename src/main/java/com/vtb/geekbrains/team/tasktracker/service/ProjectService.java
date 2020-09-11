package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Project;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import com.vtb.geekbrains.team.tasktracker.exception.ResourceNotFoundException;
import com.vtb.geekbrains.team.tasktracker.exception.TaskTrackerException;
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

    public void deleteById(Long id, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with email %s not found", email)));
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Project with id %d not found", id)));
        if (!user.getId().equals(project.getManager().getId())) {
            throw new TaskTrackerException("Only project's manager can delete project");
        }
        projectRepository.deleteById(id);
    }

    public Project createNewProject(String title, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with email %s not found", email)));
        Project project = new Project();
        project.setTitle(title);
        project.setManager(user);
        project.getMembers().add(user);
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
                .orElseThrow(() -> new ResourceNotFoundException(String.format("User with email %s not found", login)));
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Project with id %d not found", id)));
        if (user.getId().equals(project.getManager().getId())) {
            throw new TaskTrackerException("Project manager can't be deleted");
        }
        project.getMembers().remove(user);
        projectRepository.save(project);
    }
}
