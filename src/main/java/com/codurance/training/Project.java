package com.codurance.training;

import com.codurance.training.tasks.Task;

public class Project {
    private final String projectName;
    private final Task task;

    public Project(String projectName, Task task) {
        this.projectName = projectName;
        this.task = task;
    }

}
