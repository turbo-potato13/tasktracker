package com.vtb.geekbrains.team.tasktracker.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInResponse {
    private String name;
    private String token;
}
