package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommand;

import java.io.IOException;

public class ShowCommand implements ICommand {
    private final Commands commands;

    public ShowCommand(Commands commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String args) throws IOException {
        commands.show();
    }
}
