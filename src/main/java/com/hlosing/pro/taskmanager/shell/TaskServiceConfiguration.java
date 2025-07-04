package com.hlosing.pro.taskmanager.shell;

import com.hlosing.pro.taskmanager.service.FileTaskService;
import com.hlosing.pro.taskmanager.service.InMemoryTaskService;
import com.hlosing.pro.taskmanager.service.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskServiceConfiguration {

    @Bean
    public TaskService inMemoryTaskService() {
        return new InMemoryTaskService();
    }

    @Bean
    public TaskService fileTaskService() {
        return new FileTaskService();
    }
}
