package com.jeffrey.taskapp2.service;

import com.jeffrey.taskapp2.entity.Task;
import com.jeffrey.taskapp2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImp implements TaskService {
    @Autowired
    private TaskRepository repository;
    @Override
    public List<Task> getAllTask() {
        return repository.findAllTasks();
    }
    public Task addTask(Task task){
        return repository.saveTask(task);
    };
    public void updateTaskStatus(Long id){
        repository.markedTask(id);
    }
    @Override
    public void deleteTask(Long id) {
        repository.deleteTask(id);
    }
}
