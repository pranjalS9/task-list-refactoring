package com.codurance.training.commands.factory;

import com.codurance.training.commands.enums.CommandTypes;
import com.codurance.training.commands.interfaces.Command;
import com.codurance.training.commands.service.CommandService;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final Map<CommandTypes, Command> commands = new HashMap<>();

    public void register(CommandTypes commandName, Command command) {
        commands.put(commandName, command);
    }

    public Command getCommand(CommandTypes commandName) {
        return commands.get(commandName);
    }

    public void registerAll(CommandService commandService) {
        register(CommandTypes.SHOW, args -> commandService.show());
        register(CommandTypes.ADD, commandService::add);
        register(CommandTypes.CHECK, commandService::check);
        register(CommandTypes.UNCHECK, commandService::uncheck);
    }
}
