package com.codurance.training;

import com.codurance.training.tasks.Task;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProjectsTest {

    @Test
    public void addProjectTest() {
        Projects projects = new Projects();
        String projectName = "Project-1";

        projects.addProject(projectName);
        List<Task> tasks = projects.getProjectTasks(projectName);

        assertNotNull(tasks);
        assertTrue(tasks.isEmpty());
    }

    @Test
    public void addTaskInAExistingProjectSuccessfullyTest() {
        Projects projects = new Projects();
        String projectName = "Project-1";
        Task task = new Task(1, "My Test", false);

        projects.addProject(projectName);
        projects.addTask(projectName, task);

        List<Task> tasks = projects.getProjectTasks(projectName);

        assertNotNull(tasks);
        assertEquals(1, tasks.size());
        assertTrue(tasks.contains(task));
    }

    @Test
    public void addTaskInAnUnknownProjectThrowExceptionTest() {
        Projects projects = new Projects();
        String projectName = "Project-1";
        Task task = new Task(1, "My Test", false);

        List<Task> tasks = projects.getProjectTasks(projectName);
        assertNull(tasks);
        assertThrows(IllegalArgumentException.class, () -> projects.addTask(projectName, task));
    }
}
