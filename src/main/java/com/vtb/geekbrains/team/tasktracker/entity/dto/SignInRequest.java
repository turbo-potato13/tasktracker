package com.vtb.geekbrains.team.tasktracker.entity.dto;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}
