package com.codurance.training.commands;

import com.codurance.training.projects.Projects;
import com.codurance.training.commands.service.CommandService;
import com.codurance.training.commands.factory.CommandFactory;
import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class CommandExecutorTest {

    @Test
    public void executeAddProjectWithNoTaskTest() {
        StringWriter writer = new StringWriter();
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.registerAll(new CommandService(new Projects(), writer));
        CommandExecutor taskList = new CommandExecutor(commandFactory);

        taskList.execute("add project Project-1");
        taskList.execute("show");

        String expectedOutput = "Project-1\n";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void executeAddProjectWithOneTaskTest() {
        StringWriter writer = new StringWriter();
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.registerAll(new CommandService(new Projects(), writer));
        CommandExecutor taskList = new CommandExecutor(commandFactory);

        taskList.execute("add project Project-1");
        taskList.execute("add task Project-1 Task-1");
        taskList.execute("show");

        String expectedOutput = "Project-1\n" + "[ ] 1: Task-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void executeAddProjectWithMultipleTaskTest() {
        StringWriter writer = new StringWriter();
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.registerAll(new CommandService(new Projects(), writer));
        CommandExecutor taskList = new CommandExecutor(commandFactory);

        taskList.execute("add project Project-1");
        taskList.execute("add task Project-1 Task-1");
        taskList.execute("add task Project-1 Task-2");
        taskList.execute("show");

        String expectedOutput = "Project-1\n" + "[ ] 1: Task-1\n" + "[ ] 2: Task-2\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void executeAddProjectWithOneTaskAndThenCheckTest() {
        StringWriter writer = new StringWriter();
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.registerAll(new CommandService(new Projects(), writer));
        CommandExecutor taskList = new CommandExecutor(commandFactory);

        taskList.execute("add project Project-1");
        taskList.execute("add task Project-1 Task-1");
        taskList.execute("check 1");
        taskList.execute("show");

        String expectedOutput = "Project-1\n" + "[x] 1: Task-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void executeAddProjectWithMultipleTaskThenCheckOneThenUncheckTest() {
        StringWriter writer = new StringWriter();
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.registerAll(new CommandService(new Projects(), writer));
        CommandExecutor taskList = new CommandExecutor(commandFactory);

        taskList.execute("add project Project-1");
        taskList.execute("add task Project-1 Task-1");
        taskList.execute("check 1");
        taskList.execute("uncheck 1");
        taskList.execute("show");

        String expectedOutput = "Project-1\n" + "[ ] 1: Task-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }
}
