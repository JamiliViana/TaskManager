package com.jamili.taskmanager.controller;

import com.jamili.taskmanager.model.Task;

import com.jamili.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Task> getAll() {
        return service.getAllTasks();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Task createTask(@RequestBody @Valid Task task){
        return service.createTask(task);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return service.updateTask(id,updatedTask);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}
