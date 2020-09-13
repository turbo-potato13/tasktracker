package com.vtb.geekbrains.team.tasktracker.exception;

import lombok.Data;

import java.util.Date;

@Data
public class TaskServiceError {
    private int status;
    private String message;
    private Date timestamp;

    public TaskServiceError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
