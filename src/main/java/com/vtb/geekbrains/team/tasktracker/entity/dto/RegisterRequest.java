package com.vtb.geekbrains.team.tasktracker.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ToString.Exclude
    private String password;
}
