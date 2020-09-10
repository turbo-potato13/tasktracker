package com.vtb.geekbrains.team.tasktracker.controller;

import com.vtb.geekbrains.team.tasktracker.dto.CommentDTO;
import com.vtb.geekbrains.team.tasktracker.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    @GetMapping()
    public List<CommentDTO> getAllComments() {
        return commentService.findAll();
    }


}
