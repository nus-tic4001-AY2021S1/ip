package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import duke.exception.DukeException;

/**
 * JUnit tests for Deadline class.
 */
public class DeadlineTest {
    @Test
    public void testGetDescription() throws DukeException {
        Task deadline = new Deadline("Have lunch with John", "2020-12-25 1800");
        assertEquals("Have lunch with John", deadline.getDescription());
    }

    @Test
    public void testGetIsDone() throws DukeException {
        Task deadline = new Deadline("Have lunch with John", "2020-12-25 1800");
        Task deadlineWithDoneStatus = new Deadline("Have lunch with John", "2020-12-25T18:00", true);
        assertFalse(deadline.getIsDone());
        assertTrue(deadlineWithDoneStatus.getIsDone());
    }

    @Test
    public void testToString() throws DukeException {
        Task deadline = new Deadline("Have lunch with John", "2020-12-25 1800");
        Task deadlineWithDoneStatus = new Deadline("Have lunch with John", "2020-12-25T18:00", true);
        assertEquals("[D][\u2718] Have lunch with John (by: 25 Dec 2020 6:00PM)", deadline.toString());
        assertEquals("[D][\u2713] Have lunch with John (by: 25 Dec 2020 6:00PM)", deadlineWithDoneStatus.toString());
    }
}
