package com.codurance.training;

import com.codurance.training.tasks.Task;

import java.util.List;
import java.util.Map;

public class Project {
    private final String projectName;
    private final Task task;

    public Project(String projectName, Task task) {
        this.projectName = projectName;
        this.task = task;
    }

    public void addTask(Map<String, List<Task>> projects) {
        List<Task> projectTasks = projects.get(projectName);
        if (projectTasks == null) {
            throw new IllegalArgumentException("Unknown project: " + projectName);
        }
        projectTasks.add(task);
    }
}
