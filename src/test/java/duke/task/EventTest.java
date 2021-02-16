package duke.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import duke.exception.DukeException;

/**
 * JUnit tests for Event class.
 */
public class EventTest {
    @Test
    public void testGetDescription() throws DukeException {
        Task event = new Event("Have lunch with John", "2020-09-25 1800 60");
        assertEquals("Have lunch with John", event.getDescription());
    }

    @Test
    public void testGetIsDone() throws DukeException {
        Task event = new Event("Have lunch with John", "2020-09-25 1800 60");
        Task eventWithDoneStatus = new Event("Have lunch with John", "2020-09-25T18:00",
                "60", true);
        assertFalse(event.getIsDone());
        assertTrue(eventWithDoneStatus.getIsDone());
    }

    @Test
    public void testToString() throws DukeException {
        Task event = new Event("Have lunch with John", "2020-09-25 1800 60");
        Task eventWithDoneStatus = new Event("Have lunch with John", "2020-09-25T18:00",
                "60", true);
        assertEquals("[E][\u2718] Have lunch with John (at: 25 Sep 2020 6:00PM to 25 Sep 2020 7:00PM)",
                event.toString());
        assertEquals("[E][\u2713] Have lunch with John (at: 25 Sep 2020 6:00PM to 25 Sep 2020 7:00PM)",
                eventWithDoneStatus.toString());
    }
}
