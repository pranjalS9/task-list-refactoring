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
}
