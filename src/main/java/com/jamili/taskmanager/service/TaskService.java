package com.jamili.taskmanager.service;

import com.jamili.taskmanager.advice.exceptions.NotFoundException;
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

    public Task updateTask(Long id, Task task){
        Task taskToUpdate = repository.getTaskById(id);
        if (taskToUpdate == null){
            throw new NotFoundException();
        }
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setStatus(task.getStatus());
        return repository.save(taskToUpdate);
    }

    public void deleteTask(Long id){
        Task taskToDelete = repository.getTaskById(id);
        if (taskToDelete == null){
            throw new NotFoundException();
        }
        repository.delete(taskToDelete);
    }
}
