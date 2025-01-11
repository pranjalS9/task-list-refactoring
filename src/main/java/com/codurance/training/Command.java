package com.codurance.training;

import com.codurance.training.tasks.Task;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Command {
    private final Projects projects;
    private final Writer writer;

    public Command(Projects projects, Writer writer) {
        this.projects = projects;
        this.writer = writer;
    }

    public void show() throws IOException {
        List<String> projectNames = projects.getProjectNames();
        for (String projectName : projectNames) {
            writer.write(projectName);
            writer.write("\n");
            List<Task> tasks = projects.getProjectTasks(projectName);
            for (Task task : tasks) {
                writer.write(String.format("[%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription()));
            }
        }
    }
}
