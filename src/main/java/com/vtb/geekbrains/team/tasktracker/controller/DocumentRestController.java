package com.vtb.geekbrains.team.tasktracker.controller;

import com.vtb.geekbrains.team.tasktracker.entity.Document;
import com.vtb.geekbrains.team.tasktracker.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/document")
@RequiredArgsConstructor
public class DocumentRestController {
    private final DocumentService documentService;

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.findAll();
    }
}
