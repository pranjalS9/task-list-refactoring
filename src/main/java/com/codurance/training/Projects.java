package com.codurance.training;

import com.codurance.training.tasks.Task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Projects {
    private final Map<String, List<Task>> projects = new LinkedHashMap<>();
    private long lastId = 0;

    public void addTask(String projectName, Task task) {
        List<Task> projectTasks = getProjectTasks(projectName);
        if (projectTasks == null) {
            throw new IllegalArgumentException("Unknown project: " + projectName);
        }
        projectTasks.add(task);
    }

    public List<String> getProjectNames() {
        return new ArrayList<>(projects.keySet());
    }

    public List<Task> getProjectTasks(String projectName) {
        return projects.get(projectName);
    }

    public void addProject(String name) {
        projects.put(name, new ArrayList<>());
    }

    public long nextId() {
        return ++lastId;
    }

    String getTasksAsFormattedString(List<Task> tasks) {
        StringBuilder outputString = new StringBuilder();
        for (Task t : tasks) {
            outputString.append(t.getFormattedTaskString());
        }
        return outputString.toString();
    }

    public String getProjectsAsFormattedString(List<String> projectNames) {
        StringBuilder projectsAsFormattedString = new StringBuilder();
        for (String projectName : projectNames) {
            List<Task> tasks = getProjectTasks(projectName);
            projectsAsFormattedString.append(projectName).append("\n").append(getTasksAsFormattedString(tasks));
        }
        return projectsAsFormattedString.toString();
    }
}
