package com.codurance.training.commands;

import com.codurance.training.commands.factory.CommandFactory;
import com.codurance.training.commands.service.CommandService;
import com.codurance.training.projects.Projects;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CommandExecutorTest {

    @Test
    public void executeCommandWithCorrectCommandTest() {
        StringWriter writer = new StringWriter();
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.registerAll(new CommandService(new Projects(), writer));
        CommandExecutor commandExecutor = new CommandExecutor(commandFactory);

        commandExecutor.execute("add project Project-1");
        commandExecutor.execute("show");

        String expectedOutput = "Project-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void executeCommandWithIncorrectCommandTest() {
        StringWriter writer = new StringWriter();
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.registerAll(new CommandService(new Projects(), writer));
        CommandExecutor commandExecutor = new CommandExecutor(commandFactory);

        assertThrows(IllegalArgumentException.class, () -> commandExecutor.execute("test project Project-1"));
    }
}
