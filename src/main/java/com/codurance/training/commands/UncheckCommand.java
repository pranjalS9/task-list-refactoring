package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.Command;
import com.codurance.training.commands.service.CommandService;

public class UncheckCommand implements Command {
    private final CommandService commandService;

    public UncheckCommand(CommandService commands) {
        this.commandService = commands;
    }

    @Override
    public void execute(String args) {
        commandService.uncheck(args);
    }
}
