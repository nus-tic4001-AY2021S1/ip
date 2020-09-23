package duke.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    @Test
    public void testStringConversion() {
        assertEquals("[E][✘] project meeting (at: meeting room #1-2)" , new Event("project meeting", "meeting room #1-2").toString());
    }
}
