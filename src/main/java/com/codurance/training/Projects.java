package com.codurance.training;

import com.codurance.training.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Projects {
    private final Map<String, List<Task>> projects;

    public Projects(Map<String, List<Task>> projects) {
        this.projects = projects;
    }

    public void addTask(String projectName, Task task) {
        List<Task> projectTasks = getProjectTasks(projectName);
        if (projectTasks == null) {
            throw new IllegalArgumentException("Unknown project: " + projectName);
        }
        projectTasks.add(task);
    }

    public List<Task> getProjectTasks(String projectName) {
        return projects.get(projectName);
    }

    public void addProject(String name) {
        projects.put(name, new ArrayList<>());
    }
}
