package com.vtb.geekbrains.team.tasktracker.controller;

import com.vtb.geekbrains.team.tasktracker.entity.*;
import com.vtb.geekbrains.team.tasktracker.entity.Project;
import com.vtb.geekbrains.team.tasktracker.entity.dto.SubscriptionRequest;
import com.vtb.geekbrains.team.tasktracker.service.ProjectService;
import com.vtb.geekbrains.team.tasktracker.service.SubscriptionService;
import com.vtb.geekbrains.team.tasktracker.service.TaskService;
import com.vtb.geekbrains.team.tasktracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/api/v1/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final UserService userService;
    private final TaskService taskService;
    private final ProjectService projectService;

    @PostMapping
    public void subscribe(SubscriptionRequest subscriptionRequest, Principal principal) {
        User user = userService.findByEmail(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("No such user with email + " + principal.getName()));

        Task task = taskService.findEntityById(subscriptionRequest.getTaskId())
                .orElseThrow(() -> new UsernameNotFoundException("No such task with id + " + subscriptionRequest.getId()));


        Project project = projectService.findById(subscriptionRequest.getProjectId());

        EventType eventType = EventType.valueOf(subscriptionRequest.getEventType());

        Subscription subscription = Subscription.builder().project(project).task(task).user(user).eventType(eventType).build();
        subscriptionService.subscribe(subscription);
    }


    @DeleteMapping
    public void unsubscibe(SubscriptionRequest subscriptionRequest, Principal principal) {
        Long subScriptionId = subscriptionRequest.getId();

        User user = userService.findByEmail(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("No such user with email + " + principal.getName()));

        Task task = taskService.findEntityById(subscriptionRequest.getTaskId())
                .orElseThrow(() -> new UsernameNotFoundException("No such task with id + " + subscriptionRequest.getTaskId()));


        Project project = projectService.findById(subscriptionRequest.getProjectId());

        EventType eventType = EventType.valueOf(subscriptionRequest.getEventType());

        Subscription subscription = Subscription.builder()
                .project(project)
                .task(task)
                .user(user)
                .eventType(eventType)
                .id(subScriptionId)
                .build();
        subscriptionService.unSubscribe(subscription);
    }

}
