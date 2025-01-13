package com.codurance.training.commands.factory;

import com.codurance.training.commands.*;
import com.codurance.training.commands.enums.CommandTypes;
import com.codurance.training.commands.interfaces.ICommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map<CommandTypes, ICommand> commands = new HashMap<>();

    public void register(CommandTypes commandName, ICommand command) {
        commands.put(commandName, command);
    }

    public ICommand getCommand(CommandTypes commandName) {
        return commands.get(commandName);
    }

    public void registerAll(Commands commandService) {
        register(CommandTypes.SHOW, args -> new ShowCommand(commandService));
        register(CommandTypes.ADD, args -> new AddCommand(commandService));
        register(CommandTypes.CHECK, args -> new CheckCommand(commandService));
        register(CommandTypes.UNCHECK, args -> new UncheckCommand(commandService));
    }
}
