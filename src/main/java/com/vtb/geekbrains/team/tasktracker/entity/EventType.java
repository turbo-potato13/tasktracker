package com.vtb.geekbrains.team.tasktracker.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EventType {
    CREATED("CREATED"), COMMENT_ADDED("COMMENT ADDED"), EDITED("EDITED");

    private final String s;
}
