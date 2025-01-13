package com.codurance.training.commands.factory;

import com.codurance.training.commands.*;
import com.codurance.training.commands.interfaces.ICommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map<String, ICommand> commands = new HashMap<>();

    public void register(String commandName, ICommand command) {
        commands.put(commandName, command);
    }

    public ICommand getCommand(String commandName) {
        return commands.get(commandName);
    }

    public void registerAll(Commands commandService) {
        register("show", args -> new ShowCommand(commandService));
        register("add", args -> new AddCommand(commandService));
        register("check", args -> new CheckCommand(commandService));
        register("uncheck", args -> new UncheckCommand(commandService));
    }
}
