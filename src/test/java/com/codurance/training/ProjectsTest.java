package com.codurance.training;

import com.codurance.training.tasks.Task;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ProjectsTest {

    @Test
    public void addTaskInAExistingProjectSuccessfullyTest() {
        Map<String, List<Task>> projectsMap = new LinkedHashMap<>();
        Projects projects = new Projects(projectsMap);
        String projectName = "Project-1";
        Task task = new Task(1, "My Test", false);

        projects.addProject(projectName);
        projects.addTask(projectName, task);

        List<Task> tasks = projects.getProjectTasks(projectName);

        assertNotNull(tasks);
        assertEquals(1, tasks.size());
        assertTrue(tasks.contains(task));
    }
}
