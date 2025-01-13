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

    @Test
    public void isIdSameReturnsFalseTest() {
        Task task = new Task(1, "Test task", false);
        assertFalse(task.isIdSame(2));
    }

    @Test
    public void getFormattedTaskStringNotDoneTest() {
        Task task = new Task(1, "Test task", false);
        String expected = "[ ] 1: Test task\n";
        assertEquals(expected, task.getFormattedTaskString().replace("\r\n", "\n"));
    }

    @Test
    public void getFormattedTaskStringDoneTest() {
        Task task = new Task(1, "Test task", true);
        String expected = "[x] 1: Test task\n";
        assertEquals(expected, task.getFormattedTaskString().replace("\r\n", "\n"));
    }
}
