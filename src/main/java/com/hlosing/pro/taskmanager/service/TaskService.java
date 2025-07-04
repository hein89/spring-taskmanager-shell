package com.hlosing.pro.taskmanager.service;

import com.hlosing.pro.taskmanager.model.Task;
import java.util.List;

public interface TaskService {
    void addTask(String description);
    List<Task> getAllTasks();
    Task updateTask(String id, String description);
    Task deleteTask(String id);
}