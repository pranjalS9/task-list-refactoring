package com.codurance.training;

import com.codurance.training.tasks.Task;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static java.lang.System.out;

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

    public void setDone(String idString, boolean done, Projects projects) {
        int id = Integer.parseInt(idString);
        List<String> projectNames = projects.getProjectNames();
        for (String projectName : projectNames) {
            List<Task> tasks = projects.getProjectTasks(projectName);
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }
}
