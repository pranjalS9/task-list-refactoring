package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TaskTest {

    @Test
    public void taskInitializationTest() {
        Task task = new Task(1L, "Test task", false);
        assertEquals(1L, task.getId());
        assertEquals("Test task", task.getDescription());
        assertFalse(task.isDone());
    }
}
