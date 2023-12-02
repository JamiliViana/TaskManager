package com.jamili.taskmanager.service;

import com.jamili.taskmanager.model.Task;
import com.jamili.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task createTask (Task task){
        return repository.save(task);
    }

    public List<Task> getAllTasks(){
        return repository.findAll();
    }
}
