package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommand;

public class CheckCommand implements ICommand {
    private final Commands commands;

    public CheckCommand(Commands commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String args) {
        commands.check(args);
    }
}
