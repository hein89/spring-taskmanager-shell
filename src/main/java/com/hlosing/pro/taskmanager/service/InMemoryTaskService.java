package com.hlosing.pro.taskmanager.service;

import com.hlosing.pro.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTaskService implements TaskService {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public Task updateTask(String id, String description) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .map(task -> {
                    task.setDescription(description);
                    return task;
                })
                .orElseThrow(() -> new IllegalArgumentException("Task mit ID " + id + " nicht gefunden"));
    }

    @Override
    public Task deleteTask(String id) {
        Optional<Task> taskOptional = tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();

        if (taskOptional.isPresent()) {
            Task taskToRemove = taskOptional.get();
            tasks.remove(taskToRemove);
            return taskToRemove;
        } else {
            throw new IllegalArgumentException("Aufgabe mit ID " + id + " nicht gefunden.");
        }
    }


}
