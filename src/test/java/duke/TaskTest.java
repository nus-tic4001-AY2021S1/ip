package duke;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import duke.task.Task;
import duke.task.Todo;

/**
 * JUnit tests for Task class.
 */
public class TaskTest {
    private Task task = new Todo("Have lunch with John");
    private Task task2 = new Todo("Have lunch with John", true);

    @Test
    public void testGetDescription() {
        assertEquals("Have lunch with John", task.getDescription());
    }

    @Test
    public void testGetIsDone() {
        assertEquals(false, task.getIsDone());
        assertEquals(true, task2.getIsDone());
    }

    @Test
    public void testToString() {
        assertEquals("[T][\u2718] Have lunch with John", task.toString());
        assertEquals("[T][\u2713] Have lunch with John", task2.toString());
    }
}
