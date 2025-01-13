package com.codurance.training.commands;

import com.codurance.training.commands.interfaces.ICommand;

public class UncheckCommand implements ICommand {
    private final Commands commands;

    public UncheckCommand(Commands commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String args) {
        commands.uncheck(args);
    }
}
