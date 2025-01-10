package com.codurance.training;

import com.codurance.training.tasks.Task;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

public class Command {
    private final Map<String, List<Task>> projects;
    private final Writer writer;

    public Command(Map<String, List<Task>> projects, Writer writer) {
        this.projects = projects;
        this.writer = writer;
    }

    public void show() throws IOException {
        for (Map.Entry<String, List<Task>> project : projects.entrySet()) {
            writer.write(project.getKey());
            writer.write("\n");
            for (Task task : project.getValue()) {
                writer.write(String.format("[%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription()));
            }
        }
    }
}
