package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommand;
import com.codurance.training.commands.service.CommandService;

public class AddCommand implements ICommand {
    private final CommandService commandService;

    public AddCommand(CommandService commands) {
        this.commandService = commands;
    }

    @Override
    public void execute(String args) {
        commandService.add(args);
    }
}
