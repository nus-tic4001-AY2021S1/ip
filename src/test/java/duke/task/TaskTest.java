package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * JUnit tests for Task class.
 */
public class TaskTest {
    private Task task = new Todo("Have lunch with John");
    private Task taskWithDoneStatus = new Todo("Have lunch with John", true);

    @Test
    public void testGetDescription() {
        assertEquals("Have lunch with John", task.getDescription());
    }

    @Test
    public void testGetIsDone() {
        assertEquals(false, task.getIsDone());
        assertEquals(true, taskWithDoneStatus.getIsDone());
    }

    @Test
    public void testToString() {
        assertEquals("[T][\u2718] Have lunch with John", task.toString());
        assertEquals("[T][\u2713] Have lunch with John", taskWithDoneStatus.toString());
    }
}
