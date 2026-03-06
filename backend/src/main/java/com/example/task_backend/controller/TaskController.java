package com.example.task_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_backend.model.Task;
import com.example.task_backend.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService; // Ahora usamos el servicio

    @GetMapping
    public List<Task> getAll() {
        return taskService.findAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.save(task);
    }
}