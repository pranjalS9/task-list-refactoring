package com.codurance.training.commands;

import com.codurance.training.commands.service.CommandService;
import com.codurance.training.projects.Projects;
import com.codurance.training.tasks.Task;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowCommandTest {

    @Test
    public void executeTest() throws IOException {
        StringWriter writer = new StringWriter();
        Projects projects = new Projects();
        String projectName = "Project-1";
        Task task = new Task(1, "Task-1", false);

        projects.addProject(projectName);
        projects.addTask(projectName, task);

        CommandService commandService = new CommandService(projects, writer);

        ShowCommand showCommand = new ShowCommand(commandService);
        showCommand.execute(null);

        String expectedOutput = "Project-1\n" + "[ ] 1: Task-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }
}
