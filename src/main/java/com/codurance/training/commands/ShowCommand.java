package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommand;
import com.codurance.training.commands.service.CommandService;

import java.io.IOException;

public class ShowCommand implements ICommand {
    private final CommandService commandService;

    public ShowCommand(CommandService commands) {
        this.commandService = commands;
    }

    @Override
    public void execute(String args) throws IOException {
        commandService.show();
    }
}
