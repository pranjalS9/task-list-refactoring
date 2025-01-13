package com.codurance.training.tasks;

import com.codurance.training.commands.enums.CommandTypes;
import com.codurance.training.commands.factory.CommandFactory;

public final class CommandExecutor {

    private final CommandFactory commandFactory;

    public CommandExecutor(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        String args = commandRest.length > 1 ? commandRest[1] : "";

        try {
            commandFactory.getCommand(CommandTypes.getCommandType(command)).execute(args);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
