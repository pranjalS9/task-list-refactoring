package com.codurance.training;

import com.codurance.training.tasks.Task;

import java.util.List;
import java.util.Map;

public class Project {
    private final String project;
    private final String description;
    private final long nextId;

    public Project(String project, String description, long nextId) {
        this.project = project;
        this.description = description;
        this.nextId = nextId;
    }

    public void addTask(Map<String, List<Task>> projects) {
        List<Task> projectTasks = projects.get(project);
        if (projectTasks == null) {
            throw new IllegalArgumentException("Unknown project: " + project);
        }
        projectTasks.add(new Task(nextId, description, false));
    }
}
