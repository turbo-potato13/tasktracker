package com.vtb.geekbrains.team.tasktracker.controller;

import com.vtb.geekbrains.team.tasktracker.entity.Furniture;
import com.vtb.geekbrains.team.tasktracker.service.FurnitureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/furniture")
@RestController
@RequiredArgsConstructor
public class FurnitureRestController {

    private final FurnitureService furnitureService;

    @GetMapping
    public List<Furniture> getAllFurnitures(){
        return furnitureService.findAll();
    }
}
