package com.codurance.training.commands.factory;

import com.codurance.training.commands.enums.CommandTypes;
import com.codurance.training.commands.interfaces.ICommand;
import com.codurance.training.commands.service.CommandService;
import com.codurance.training.projects.Projects;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    @Test
    public void registerAndRetrieveCommandTest() {
        CommandService commandService = new CommandService(new Projects(), new StringWriter());
        CommandFactory commandFactory = new CommandFactory();

        ICommand addCommand = commandService::add;
        commandFactory.register(CommandTypes.ADD, addCommand);
        ICommand retrievedCommand = commandFactory.getCommand(CommandTypes.ADD);

        assertEquals(addCommand, retrievedCommand);
    }
}
