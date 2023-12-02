package com.jamili.taskmanager.controller;

import com.jamili.taskmanager.model.Task;

import com.jamili.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAll() {
        return service.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return service.createTask(task);
    }
}