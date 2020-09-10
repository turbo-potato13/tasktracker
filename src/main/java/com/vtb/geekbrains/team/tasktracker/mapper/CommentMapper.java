package com.vtb.geekbrains.team.tasktracker.mapper;

import com.vtb.geekbrains.team.tasktracker.dto.CommentDTO;
import com.vtb.geekbrains.team.tasktracker.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentMapper {

    public CommentDTO map(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
