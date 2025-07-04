package com.hlosing.pro.taskmanager.shell;

import com.hlosing.pro.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TaskServiceManager {

    private final TaskService inMemoryTaskService;
    private final TaskService fileTaskService;

    private TaskService activeService;

    // Wenn man mehrere Beans konfiguriert hat die vom gleichen Typ sind (siehe TaskServiceConfiguration)
    // benötigt man @Qualifier.

    // Spring kann nicht anhand der Variablennamen entscheiden, welche Bean wohin gehört – denn Spring verwendet Typen
    // und keine Namen beim Auflösen von Abhängigkeiten (außer du verwendest @Qualifier).
    @Autowired
    public TaskServiceManager(@Qualifier("inMemoryTaskService") TaskService inMemoryTaskService,
                              @Qualifier("fileTaskService") TaskService fileTaskService) {
        this.inMemoryTaskService = inMemoryTaskService;
        this.fileTaskService = fileTaskService;

        // Standard-Service festlegen
        this.activeService = fileTaskService;
    }

    public TaskService getActiveService() {
        return activeService;
    }

    public String switchService(String serviceName) {
        if ("memory".equalsIgnoreCase(serviceName)) {
            activeService = inMemoryTaskService;
            return "Wechsel zu InMemoryTaskService";
        } else if ("file".equalsIgnoreCase(serviceName)) {
            activeService = fileTaskService;
            return "Wechsel zu FileTaskService";
        } else {
            return "Unbekannter Service: " + serviceName;
        }
    }
}
