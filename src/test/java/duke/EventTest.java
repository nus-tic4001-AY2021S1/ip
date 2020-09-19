package duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit tests for Event class
 */
public class EventTest {
    @Test
    public void testGetDescription() {
        Task testEvent = new Event("Have lunch with John", "2/10/2019 2-4pm");
        Task testEvent2 = new Event("Have lunch with John", "2/10/2019 2-4pm", true);
        assertEquals("Have lunch with John", testEvent.getDescription());
    }

    @Test
    public void testGetIsDone() {
        Task testEvent = new Event("Have lunch with John", "2/10/2019 2-4pm");
        Task testEvent2 = new Event("Have lunch with John", "2/10/2019 2-4pm", true);
        assertEquals(false, testEvent.getIsDone());
        assertEquals(true, testEvent2.getIsDone());
    }

    @Test
    public void testToString() {
        Task testEvent = new Event("Have lunch with John", "2/10/2019 2-4pm");
        Task testEvent2 = new Event("Have lunch with John", "2/10/2019 2-4pm", true);
        assertEquals("[E][N] Have lunch with John (at: 2/10/2019 2-4pm)", testEvent.toString());
        assertEquals("[E][Y] Have lunch with John (at: 2/10/2019 2-4pm)", testEvent2.toString());
    }
}