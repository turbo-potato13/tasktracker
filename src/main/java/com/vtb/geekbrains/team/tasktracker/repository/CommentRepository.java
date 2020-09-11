package com.vtb.geekbrains.team.tasktracker.repository;

import com.vtb.geekbrains.team.tasktracker.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
