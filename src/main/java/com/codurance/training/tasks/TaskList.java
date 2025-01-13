package com.codurance.training.tasks;

import com.codurance.training.commands.*;
import com.codurance.training.Projects;

import java.io.Writer;

public final class TaskList {

    private final Commands commands;
    private final ShowCommand showCommand;
    private final AddCommand addCommand;
    private final CheckCommand checkCommand;
    private final UncheckCommand uncheckCommand;

    public TaskList(Writer writer) {
        Projects projects = new Projects();
        this.commands = new Commands(projects, writer);
        this.showCommand = new ShowCommand(commands);
        this.addCommand = new AddCommand(commands);
        this.checkCommand = new CheckCommand(commands);
        this.uncheckCommand = new UncheckCommand(commands);
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
                addCommand.execute(args);
                break;
            case "check":
                checkCommand.execute(args);
                break;
            case "uncheck":
                uncheckCommand.execute(args);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
