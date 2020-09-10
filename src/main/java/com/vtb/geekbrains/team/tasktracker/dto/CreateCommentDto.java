package com.vtb.geekbrains.team.tasktracker.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CreateCommentDto {
    private final String content;
    private final Long task;
}
