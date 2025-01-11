package com.codurance.training.tasks;

import com.codurance.training.Command;
import com.codurance.training.Projects;

import java.io.Writer;

public final class TaskList {

    private final Projects projects;
    private final Command commandMethods;

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
                commandMethods.add(commandRest[1], projects);
                break;
            case "check":
                commandMethods.check(commandRest[1], projects);
                break;
            case "uncheck":
                commandMethods.uncheck(commandRest[1], projects);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
