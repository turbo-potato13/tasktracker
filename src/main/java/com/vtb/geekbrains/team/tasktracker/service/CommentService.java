package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.dto.CommentDTO;
import com.vtb.geekbrains.team.tasktracker.dto.CreateCommentDto;
import com.vtb.geekbrains.team.tasktracker.entity.Comment;
import com.vtb.geekbrains.team.tasktracker.mapper.CommentMapper;
import com.vtb.geekbrains.team.tasktracker.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final TaskService taskService;//не уверен в этом моменте

    public List<CommentDTO> findAll() {
        return commentRepository.findAll().stream()
                .map(commentMapper::map)
                .collect(Collectors.toList());
    }

    public List<CommentDTO> findAllById(Long id) {
        return commentRepository.findAll().stream()
                .filter(comment -> comment.getTask().getId().equals(id))
                .map(commentMapper::map)
                .collect(Collectors.toList());
    }

    public CommentDTO create(CreateCommentDto comment) {
        Comment comment1 = taskService.addCommentToTask(comment);
        commentRepository.save(comment1);
        return commentMapper.map(comment1);
    }
}
