package com.vtb.geekbrains.team.tasktracker.dto;

import com.vtb.geekbrains.team.tasktracker.entity.Priority;
import com.vtb.geekbrains.team.tasktracker.entity.Status;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class TaskDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final Long project;
    private final Status status;
    private final Priority priority;
    private final LocalDateTime createdAt;
    private final LocalDateTime periodOfExecution;
    private final List<CommentDTO> comments;

    @Getter
    @Builder
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class CommentDTO {
        private final Long id;
        private final String content;
        private final LocalDateTime createdAt;
    }
}
