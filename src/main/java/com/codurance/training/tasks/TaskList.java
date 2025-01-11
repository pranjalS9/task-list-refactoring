package com.codurance.training.tasks;

import com.codurance.training.Command;
import com.codurance.training.Projects;

import java.io.Writer;

public final class TaskList {

    private final Projects projects;
    private final Command commandMethods;
    private long lastId = 0;

    public TaskList(Writer writer) {
        this.projects = new Projects();
        this.commandMethods = new Command(projects, writer);
    }

    public void execute(String commandLine) throws Exception {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];

        switch (command) {
            case "show":
                commandMethods.show();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                check(commandRest[1], commandMethods, projects);
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

        if (subcommand.equals("project")) {
            projects.addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);

            Task task = new Task(nextId(), projectTask[1], false);
            String projectName = projectTask[0];

            projects.addTask(projectName, task);
        }
    }

    // I don't belong here
    private static void check(String idString, Command commandMethods, Projects projects) {
        commandMethods.setDone(idString, true, projects);
    }

    private void uncheck(String idString) {
        commandMethods.setDone(idString, false, projects);
    }

    private long nextId() {
        return ++lastId;
    }
}
