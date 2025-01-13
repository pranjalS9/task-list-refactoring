package com.codurance.training.commands.enums;

public enum CommandTypes {
    SHOW,
    ADD,
    CHECK,
    UNCHECK;

    public static CommandTypes getCommandType(String command) {
        try {
            return CommandTypes.valueOf(command.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
