package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void taskInitializationTest() {
        Task task = new Task(1, "Task 1", false);
        assertEquals(1, task.getId());
        assertEquals("Test task", task.getDescription());
        assertFalse(task.isDone());
    }

    @Test
    public void setTaskAsDoneTest() {
        Task task = new Task(1, "Task 1", false);
        task.setDone(true);
        assertTrue(task.isDone());
    }

    @Test
    public void setTaskAsNotDoneTest() {
        Task task = new Task(1, "Task 1", true);
        task.setDone(false);
        assertFalse(task.isDone());
    }

    @Test
    public void isIdSameReturnsTrueTest() {
        Task task = new Task(1, "Test task", false);
        assertTrue(task.isIdSame(1));
    }
}
