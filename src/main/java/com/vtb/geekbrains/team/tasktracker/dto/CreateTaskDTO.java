package com.vtb.geekbrains.team.tasktracker.dto;

import com.vtb.geekbrains.team.tasktracker.entity.Priority;
import com.vtb.geekbrains.team.tasktracker.entity.Status;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class CreateTaskDTO {
    private final String name;
    private final String description;
    private final Status status;
    private final Priority priority;
    private final LocalDateTime periodOfExecution;
}
