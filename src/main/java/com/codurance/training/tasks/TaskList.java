package com.codurance.training.tasks;

import com.codurance.training.commands.AddCommand;
import com.codurance.training.commands.CheckCommand;
import com.codurance.training.commands.Commands;
import com.codurance.training.Projects;
import com.codurance.training.commands.ShowCommand;

import java.io.Writer;

public final class TaskList {

    private final Commands commands;
    private final ShowCommand showCommand;
    private final AddCommand addCommand;
    private final CheckCommand checkCommand;

    public TaskList(Writer writer) {
        Projects projects = new Projects();
        this.commands = new Commands(projects, writer);
        this.showCommand = new ShowCommand(commands);
        this.addCommand = new AddCommand(commands);
        this.checkCommand = new CheckCommand(commands);
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
                commands.uncheck(commandRest[1]);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
