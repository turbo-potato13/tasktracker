package com.vtb.geekbrains.team.tasktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Priority {
    LOW("Низкий"), MEDIUM("Средний"), HIGH("Высокий");
    private final String rus;
}
