package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.dto.CommentDTO;
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

    public List<CommentDTO> findAll() {
        return commentRepository.findAll().stream()
                .map(commentMapper::map)
                .collect(Collectors.toList());
    }
}
