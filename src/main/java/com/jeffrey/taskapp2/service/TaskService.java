package com.jeffrey.taskapp2.service;

import com.jeffrey.taskapp2.entity.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getAllTask();
    public Task addTask(Task task);
    public void updateTaskStatus(Long id);
    public void deleteTask(Long id);

}
