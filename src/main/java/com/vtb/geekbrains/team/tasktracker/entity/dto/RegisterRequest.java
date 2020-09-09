package com.vtb.geekbrains.team.tasktracker.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterRequest {
    private String name;

    @NotEmpty
    @Email
    private String email;

    @ToString.Exclude
    private String password;
}
