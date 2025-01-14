package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.Command;
import com.codurance.training.commands.service.CommandService;

public class CheckCommand implements Command {
    private final CommandService commandService;

    public CheckCommand(CommandService commands) {
        this.commandService = commands;
    }

    @Override
    public void execute(String args) {
        commandService.check(args);
    }
}
