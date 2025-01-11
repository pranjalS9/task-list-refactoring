package com.codurance.training;

import com.codurance.training.tasks.Task;

import java.util.List;
import java.util.Map;

public class Project {
    private final String projectName;
    private final String taskDescription;
    private final long taskId;

    public Project(String projectName, String description, long taskId) {
        this.projectName = projectName;
        this.taskDescription = description;
        this.taskId = taskId;
    }

    public void addTask(Map<String, List<Task>> projects) {
        List<Task> projectTasks = projects.get(projectName);
        if (projectTasks == null) {
            throw new IllegalArgumentException("Unknown project: " + projectName);
        }
        projectTasks.add(new Task(taskId, taskDescription, false));
    }
}
