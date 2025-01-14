package com.codurance.training.commands;

import com.codurance.training.commands.service.CommandService;
import com.codurance.training.projects.Projects;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class AddCommandTest {

    @Test
    public void executeTest() throws IOException {
        StringWriter writer = new StringWriter();
        CommandService commandService = new CommandService(new Projects(), writer);
        AddCommand addCommand = new AddCommand(commandService);

        addCommand.execute("project Project-1");
        commandService.show();

        String expectedOutput = "Project-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }
}
