package com.codurance.training.tasks;

import com.codurance.training.Command;
import com.codurance.training.Project;
import com.codurance.training.Projects;

import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public final class TaskList {

    private final Map<String, List<Task>> projects = new LinkedHashMap<>();
    private final Writer writer;
    private long lastId = 0;

    public TaskList(Writer writer) {
        this.writer = writer;
    }

    public void execute(String commandLine) throws Exception {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        Command commandMethods = new Command(projects, writer);

        switch (command) {
            case "show":
                commandMethods.show();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                check(commandRest[1]);
                break;
            case "uncheck":
                uncheck(commandRest[1]);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        Projects projectList = new Projects(projects);

        if (subcommand.equals("project")) {
            projectList.addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);

            Project project = new Project(projectTask[0], projectTask[1], nextId());
            project.addTask(projects);
        }
    }

    private void check(String idString) {
        setDone(idString, true);
    }

    private void uncheck(String idString) {
        setDone(idString, false);
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<com.codurance.training.tasks.Task>> project : projects.entrySet()) {
            for (com.codurance.training.tasks.Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }

    private long nextId() {
        return ++lastId;
    }
}
