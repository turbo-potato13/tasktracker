package com.vtb.geekbrains.team.tasktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    BACKLOG("Бэклог"), ACTIVE("Реализуется"), READY("Готова");
    private final String rus;
}
