package com.codurance.training.tasks;

import com.codurance.training.Commands;
import com.codurance.training.Projects;

import java.io.Writer;

public final class TaskList {

    private final Projects projects;
    private final Commands commands;

    public TaskList(Writer writer) {
        this.projects = new Projects();
        this.commands = new Commands(projects, writer);
    }

    public void execute(String commandLine) throws Exception {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];

        switch (command) {
            case "show":
                commands.show();
                break;
            case "add":
                commands.add(commandRest[1], projects);
                break;
            case "check":
                commands.check(commandRest[1], projects);
                break;
            case "uncheck":
                commands.uncheck(commandRest[1], projects);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
