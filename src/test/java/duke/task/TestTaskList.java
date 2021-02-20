package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for TaskList class.
 */
public class TestTaskList {
    /**
     * Tests the correctness of the getSize() method
     */
    @Test
    public void testGetSize() {
        TaskList tasks = new TaskList();
        tasks.addTask(new Todo("Have lunch with John"));
        tasks.addTask(new Todo("Have lunch with Sam"));
        assertEquals(2, tasks.getSize());
    }
}
