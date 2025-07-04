package com.hlosing.pro.taskmanager.shell;

import com.hlosing.pro.taskmanager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class TaskCommands {

    private final TaskServiceManager taskServiceManager;

    @Autowired
    public TaskCommands(TaskServiceManager taskServiceManager) {
        this.taskServiceManager = taskServiceManager;
    }

    @ShellMethod("Fügt eine neue Aufgabe hinzu.")
    public String add(String description) {
        taskServiceManager.getActiveService().addTask(description);
        return "Aufgabe hinzugefügt: " + description;
    }

    @ShellMethod("Zeigt alle Aufgaben.")
    public String list() {
        List<Task> tasks = taskServiceManager.getActiveService().getAllTasks();
        if (tasks.isEmpty()) {
            return "Keine Aufgaben vorhanden.";
        }

        StringBuilder sb = new StringBuilder("Aufgabenliste:\n");
        for (Task task : tasks) {
            sb.append("- [").append(task.getId()).append("] ")
                    .append(task.getDescription()).append("\n");
        }
        return sb.toString();
    }

    @ShellMethod("Bearbeitet eine Aufgabe.")
    public String update(String id, String description) {
        try {
            Task updatedTask = taskServiceManager.getActiveService().updateTask(id, description);
            return "Aufgabe [" + updatedTask.getId() + "] bearbeitet: " + updatedTask.getDescription();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @ShellMethod("Löscht eine Aufgabe.")
    public String delete(String id) {
        try {
            Task deletedTask = taskServiceManager.getActiveService().deleteTask(id);
            return "Aufgabe [" + deletedTask.getId() + "] gelöscht: " + deletedTask.getDescription();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @ShellMethod("Wechselt den aktiven TaskService (memory/file).")
    public String switchService(String serviceName) {
        return taskServiceManager.switchService(serviceName);
    }

    @ShellMethod("Zeigt den aktiven TaskService an.")
    public String getActiveService() {
        return taskServiceManager.getActiveService().getClass().getSimpleName();
    }
}
