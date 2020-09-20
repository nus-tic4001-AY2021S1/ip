package duke;

import duke.exception.DukeException;
import duke.task.Deadline;
import duke.task.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit tests for Deadline class
 */
public class DeadlineTest {
    @Test
    public void testGetDescription() throws DukeException {
        Task testDeadline = new Deadline("Have lunch with John", "2020-12-25 1800");
        assertEquals("Have lunch with John", testDeadline.getDescription());
    }

    @Test
    public void testGetIsDone() throws DukeException {
        Task testDeadline = new Deadline("Have lunch with John", "2020-12-25 1800");
        Task testDeadline2 = new Deadline("Have lunch with John", "2020-12-25T18:00", true);
        assertEquals(false, testDeadline.getIsDone());
        assertEquals(true, testDeadline2.getIsDone());
    }

    @Test
    public void testToString() throws DukeException {
        Task testDeadline = new Deadline("Have lunch with John", "2020-12-25 1800");
        Task testDeadline3 = new Deadline("Have lunch with John", "2020-12-25T18:00", true);
        assertEquals("[D][N] Have lunch with John (by: Dec 25 2020 1800)", testDeadline.toString());
        assertEquals("[D][Y] Have lunch with John (by: Dec 25 2020 1800)", testDeadline3.toString());
    }
}
