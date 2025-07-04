package com.hlosing.pro.taskmanager.model;

import java.util.UUID;

public class Task {
    private String id;
    private String description;

    // Pflicht für Jackson
    public Task() {
    }

    public Task(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) { this.description = description; }
}
