package com.vtb.geekbrains.team.tasktracker.entity.dto;

import lombok.Data;

@Data
public class SubscriptionRequest {
    private Long id;

    private Long userId;

    private String eventType;

    private Long taskId;

    private Long projectId;

    SubscriptionRequest(Long userId, String eventType, Long taskId, Long projectId) {
        this.userId = userId;
        this.eventType = eventType;
        this.taskId = taskId;
        this.projectId = projectId;
    }
}
