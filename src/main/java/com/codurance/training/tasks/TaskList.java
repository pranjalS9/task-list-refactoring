package com.codurance.training.tasks;

import com.codurance.training.commands.enums.CommandTypes;
import com.codurance.training.commands.factory.CommandFactory;
import com.codurance.training.commands.interfaces.ICommand;

public final class TaskList {

    private final CommandFactory commandFactory;

    public TaskList(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        String args = commandRest.length > 1 ? commandRest[1] : "";

        try {
            CommandTypes commandType = CommandTypes.getCommandType(command);
            ICommand c = commandFactory.getCommand(commandType);
            c.execute(args);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
