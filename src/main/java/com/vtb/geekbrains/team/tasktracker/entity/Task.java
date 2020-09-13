package com.vtb.geekbrains.team.tasktracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User owner;

//    @OneToMany
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<User> performers;

    @JsonIgnore
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id")
    private Project project;

    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    @Setter
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime periodOfExecution;


    @Setter
    @OneToMany(mappedBy = "task",
            fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
}
