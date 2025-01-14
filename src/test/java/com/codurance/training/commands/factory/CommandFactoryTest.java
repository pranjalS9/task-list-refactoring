package com.codurance.training.commands.factory;

import com.codurance.training.commands.enums.CommandTypes;
import com.codurance.training.commands.interfaces.Command;
import com.codurance.training.commands.service.CommandService;
import com.codurance.training.projects.Projects;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommandFactoryTest {

    @Test
    public void registerAndRetrieveCommandTest() {
        CommandService commandService = new CommandService(new Projects(), new StringWriter());
        CommandFactory commandFactory = new CommandFactory();

        Command addCommand = commandService::add;
        commandFactory.register(CommandTypes.ADD, addCommand);
        Command retrievedCommand = commandFactory.getCommand(CommandTypes.ADD);

        assertEquals(addCommand, retrievedCommand);
    }

    @Test
    public void shouldRegisterAllCommandsTest() {
        CommandService commandService = new CommandService(new Projects(), new StringWriter());
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.registerAll(commandService);

        assertNotNull(commandFactory.getCommand(CommandTypes.SHOW));
        assertNotNull(commandFactory.getCommand(CommandTypes.ADD));
        assertNotNull(commandFactory.getCommand(CommandTypes.CHECK));
        assertNotNull(commandFactory.getCommand(CommandTypes.UNCHECK));
    }
}
