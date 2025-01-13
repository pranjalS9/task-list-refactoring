package com.codurance.training.commands.factory;

import com.codurance.training.commands.*;
import com.codurance.training.commands.enums.CommandTypes;
import com.codurance.training.commands.interfaces.ICommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<CommandTypes, ICommand> commands = new HashMap<>();

    public void register(CommandTypes commandName, ICommand command) {
        commands.put(commandName, command);
    }

    public ICommand getCommand(CommandTypes commandName) {
        return commands.get(commandName);
    }

    public void registerAll(Commands commandService) {
        register(CommandTypes.SHOW, args -> commandService.show());
        register(CommandTypes.ADD, commandService::add);
        register(CommandTypes.CHECK, commandService::check);
        register(CommandTypes.UNCHECK, commandService::uncheck);
    }
}
