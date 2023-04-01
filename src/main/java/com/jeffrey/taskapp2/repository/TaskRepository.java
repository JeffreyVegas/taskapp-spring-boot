package com.jeffrey.taskapp2.repository;


import com.jeffrey.taskapp2.entity.Task;

import java.util.List;

public interface TaskRepository  {
   public List<Task> findAllTasks();
   public Task saveTask(Task task);
   public void markedTask(Long id);
   public void deleteTask(Long id);

}
