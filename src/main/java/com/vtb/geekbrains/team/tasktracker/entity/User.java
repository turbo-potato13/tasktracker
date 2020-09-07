package com.vtb.geekbrains.team.tasktracker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Project> myProjects;
}
