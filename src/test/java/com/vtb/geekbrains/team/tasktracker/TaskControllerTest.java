package com.vtb.geekbrains.team.tasktracker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtb.geekbrains.team.tasktracker.controller.TaskController;
import com.vtb.geekbrains.team.tasktracker.entity.Priority;
import com.vtb.geekbrains.team.tasktracker.entity.Status;
import com.vtb.geekbrains.team.tasktracker.entity.Task;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TaskControllerTest {
    private final Task task = new Task(1L,
            "Task1",
            "Desc",
            Status.READY,
            Priority.LOW,
            LocalDateTime.now(),
            LocalDateTime.of(2020, 12, 14, 23, 43));

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    TaskControllerTest() {
    }

    @Test
    @Order(1)
    void tryToStart() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/task"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Order(3)
    void tryGetTaskById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/task/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Order(2)
    void tryCreateNewTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/task")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(4)
    void tryToModifyTask() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/task")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    void tryToDeleteAllTasks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/task"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(5)
    void tryToDeleteTaskById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/task/1"))
                .andExpect(status().isOk());
    }
}
