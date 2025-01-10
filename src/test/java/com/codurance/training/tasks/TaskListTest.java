package com.codurance.training.tasks;

import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class TaskListTest {

    @Test
    public void executeAddProjectWithNoTaskTest() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);

        taskList.execute("add project Project-1");
        taskList.execute("show");

        String expectedOutput = "Project-1\n";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void executeAddProjectWithOneTaskTest() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);

        taskList.execute("add project Project-1");
        taskList.execute("add task Project-1 Task-1");
        taskList.execute("show");

        String expectedOutput = "Project-1\n" + "[ ] 1: Task-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void executeAddProjectWithMultipleTaskTest() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);

        taskList.execute("add project Project-1");
        taskList.execute("add task Project-1 Task-1");
        taskList.execute("add task Project-1 Task-2");
        taskList.execute("show");

        String expectedOutput = "Project-1\n" + "[ ] 1: Task-1\n" + "[ ] 2: Task-2\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void executeAddProjectWithOneTaskAndThenCheckTest() throws Exception {
        StringWriter writer = new StringWriter();
        TaskList taskList = new TaskList(writer);

        taskList.execute("add project Project-1");
        taskList.execute("add task Project-1 Task-1");
        taskList.execute("check 1");
        taskList.execute("show");

        String expectedOutput = "Project-1\n" + "[x] 1: Task-1\n";
        String actualOutput = writer.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput, actualOutput);
    }
}
