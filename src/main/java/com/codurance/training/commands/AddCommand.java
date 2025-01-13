package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommand;

public class AddCommand implements ICommand {
    private final Commands commands;

    public AddCommand(Commands commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String args) {
        commands.add(args);
    }
}
