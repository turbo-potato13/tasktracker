package com.vtb.geekbrains.team.tasktracker.entity;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User owner;

//    @OneToMany
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<User> performers;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id")
    private Project project;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime periodOfExecution;

//    @OneToMany(mappedBy = "comment")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<Comment> comment;
}
