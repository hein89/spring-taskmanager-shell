package com.hlosing.pro.taskmanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hlosing.pro.taskmanager.model.Task;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Primary
public class FileTaskService implements TaskService {

    // Definiert den Pfad zur Datei "tasks.json" im aktuellen Arbeitsverzeichnis
    private final Path filePath = Paths.get("tasks.json");

    // Jackson-Objekt zur (De-)Serialisierung von Java-Objekten in/aus JSON
    private final ObjectMapper objectMapper = new ObjectMapper();

    // In-Memory-Liste zur Zwischenspeicherung der Aufgaben während der Laufzeit
    private final List<Task> tasks = new ArrayList<>();


    public FileTaskService() {
        loadTasks();
    }

    @Override
    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        saveTasks();
    }

    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }


    @Override
    public Task updateTask(String id, String description) {
        return tasks.stream()
                .filter(task -> task.getId().startsWith(id))
                .findFirst()
                .map(task -> {
                    task.setDescription(description);
                    saveTasks();
                    return task;
                })
                .orElse(null);
    }

    @Override
    public Task deleteTask(String id) {
        Optional<Task> optional = tasks.stream()
                .filter(task -> task.getId().startsWith(id))
                .findFirst();
        optional.ifPresent(task -> {
            tasks.remove(task);
            saveTasks();
        });
        return optional.orElse(null);
    }

    private void loadTasks() {
        if (Files.exists(filePath)) {
            try {
                List<Task> loaded = Arrays.asList(
                        objectMapper.readValue(filePath.toFile(), Task[].class)
                );
                tasks.clear();
                tasks.addAll(loaded);
            } catch (IOException e) {
                System.err.println("Fehler beim Laden der Aufgaben: " + e.getMessage());
            }
        }
    }

    private void saveTasks() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(filePath.toFile(), tasks);
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern der Aufgaben: " + e.getMessage());
        }
    }
}
