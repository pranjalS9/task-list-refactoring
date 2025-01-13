package com.codurance.training;

import com.codurance.training.tasks.Task;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static java.lang.System.out;

public class Commands {
    private final Projects projects;
    private final Writer writer;

    public Commands(Projects projects, Writer writer) {
        this.projects = projects;
        this.writer = writer;
    }

    public void show() throws IOException {
        List<String> projectNames = projects.getProjectNames();
        for (String projectName : projectNames) {
            writer.write(projectName);
            writer.write("\n");
            List<Task> tasks = projects.getProjectTasks(projectName);
            for (Task t : tasks) {
                writer.write(t.getFormattedTaskString());
            }
        }
    }

    public void check(String idString) {
        setDone(idString, true);
    }

    public void uncheck(String idString) {
        setDone(idString, false);
    }

    public void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        List<String> projectNames = projects.getProjectNames();
        for (String projectName : projectNames) {
            List<Task> tasks = projects.getProjectTasks(projectName);
            for (Task task : tasks) {
                if (task.isIdSame(id)) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }

    public void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];

        if (subcommand.equals("project")) {
            projects.addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            handleTaskCommand(subcommandRest[1]);
        }
    }

    private void handleTaskCommand(String arguments) {
        String[] projectTask = arguments.split(" ", 2);

        String projectName = projectTask[0];
        String taskDescription = projectTask[1];
        Task task = new Task(projects.nextId(), taskDescription, false);

        projects.addTask(projectName, task);
    }
}
