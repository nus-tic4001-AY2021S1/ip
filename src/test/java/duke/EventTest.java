package duke;

import duke.exception.DukeException;
import duke.task.Event;
import duke.task.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * JUnit tests for Event class.
 */
public class EventTest {
    @Test
    public void testGetDescription() throws DukeException {
        Task testEvent = new Event("Have lunch with John", "2020-09-25 1800 60");
        assertEquals("Have lunch with John", testEvent.getDescription());
    }

    @Test
    public void testGetIsDone() throws DukeException {
        Task testEvent = new Event("Have lunch with John", "2020-09-25 1800 60");
        Task testEvent2 = new Event("Have lunch with John", "2020-09-25T18:00",
                "60", true);
        assertFalse(testEvent.getIsDone());
        assertTrue(testEvent2.getIsDone());
    }

    @Test
    public void testToString() throws DukeException {
        Task testEvent = new Event("Have lunch with John", "2020-09-25 1800 60");
        Task testEvent2 = new Event("Have lunch with John", "2020-09-25T18:00",
                "60", true);
        assertEquals("[E][N] Have lunch with John (at: 25 Sep 2020 6:00PM to 25 Sep 2020 7:00PM)",
                testEvent.toString());
        assertEquals("[E][Y] Have lunch with John (at: 25 Sep 2020 6:00PM to 25 Sep 2020 7:00PM)",
                testEvent2.toString());
    }
}