package com.vtb.geekbrains.team.tasktracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    List<Project> managedProjects = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "members")
    private List<Project> projects = new ArrayList<>();

}
