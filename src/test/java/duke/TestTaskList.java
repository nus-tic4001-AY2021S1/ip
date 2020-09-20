package duke;

import duke.task.TaskList;
import duke.task.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit tests for TaskList class
 */
public class TestTaskList {
    @Test
    public void testGetSize() {
        TaskList tasks = new TaskList();
        tasks.addTask(new Todo("Have lunch with John"));
        tasks.addTask(new Todo("Have lunch with Sam"));
        assertEquals(2, tasks.getSize());
    }
}