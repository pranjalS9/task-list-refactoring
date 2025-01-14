package com.codurance.training.commands.service;

import com.codurance.training.projects.Projects;
import com.codurance.training.tasks.Task;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class CommandServiceTest {

    @Test
    public void showTest() throws IOException {
        StringWriter writer = new StringWriter();
        Projects projects = new Projects();
        String projectName = "Project-1";
        Task task = new Task(1, "Task-1", false);

        projects.addProject(projectName);
        projects.addTask(projectName, task);

        CommandService commandService = new CommandService(projects, writer);
        commandService.show();

        String expectedOutput = "Project-1\n" + "[ ] 1: Task-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void checkMarksTheTaskAsDoneTest() throws IOException {
        StringWriter writer = new StringWriter();
        Projects projects = new Projects();
        String projectName = "Project-1";
        Task task = new Task(1, "Task-1", false);

        projects.addProject(projectName);
        projects.addTask(projectName, task);

        CommandService commandService = new CommandService(projects, writer);
        commandService.check("1");
        commandService.show();

        String expectedOutput = "Project-1\n" + "[x] 1: Task-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }
}
