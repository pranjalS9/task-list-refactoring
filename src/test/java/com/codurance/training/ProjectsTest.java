package com.codurance.training;

import com.codurance.training.tasks.Task;
import org.junit.Test;
import java.util.List;
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

    @Test
    public void getProjectNamesTest() {
        Projects projects = new Projects();
        String projectName1 = "Project-1";
        String projectName2 = "Project-2";

        projects.addProject(projectName1);
        projects.addProject(projectName2);

        List<String> projectNames = projects.getProjectNames();

        assertEquals(List.of(projectName1, projectName2), projectNames);
    }

    @Test
    public void getProjectTasksTest() {
        Projects projects = new Projects();
        String projectName = "Project-1";
        Task task1 = new Task(1, "My Test 1", false);
        Task task2 = new Task(2, "My Test 2", true);

        projects.addProject(projectName);
        projects.addTask(projectName, task1);
        projects.addTask(projectName, task2);

        List<Task> tasks = projects.getProjectTasks(projectName);

        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }

    @Test
    public void nextIdReturnSequentialUniqueIdsTest() {
        Projects projects = new Projects();

        long firstId = projects.nextId();
        long secondId = projects.nextId();

        assertEquals(1, firstId);
        assertEquals(2, secondId);
    }
}
