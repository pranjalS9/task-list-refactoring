package com.codurance.training.tasks;

import com.codurance.training.commands.Commands;
import com.codurance.training.Projects;
import com.codurance.training.commands.ShowCommand;

import java.io.Writer;

public final class TaskList {

    private final Commands commands;
    private final ShowCommand showCommand;

    public TaskList(Writer writer) {
        Projects projects = new Projects();
        this.commands = new Commands(projects, writer);
        this.showCommand = new ShowCommand(commands);
    }

    public void execute(String commandLine) throws Exception {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        String args = commandRest.length > 1 ? commandRest[1] : "";

        switch (command) {
            case "show":
                showCommand.execute(args);
                break;
            case "add":
                commands.add(commandRest[1]);
                break;
            case "check":
                commands.check(commandRest[1]);
                break;
            case "uncheck":
                commands.uncheck(commandRest[1]);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
