package com.vtb.geekbrains.team.tasktracker.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentDTO {
    private final Long id;
    private final String content;
    private final LocalDateTime createdAt;
    private final Long task;
}
