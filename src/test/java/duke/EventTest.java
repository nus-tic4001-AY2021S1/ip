package duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    private Task testTask = new Event("Have lunch with John", "2/10/2019 2-4pm");
    private Task testTask2 = new Event("Have lunch with John", "2/10/2019 2-4pm", true);

    @Test
    public void testGetDescription() {
        assertEquals("Have lunch with John", testTask.getDescription());
    }

    @Test
    public void testGetIsDone() {
        assertEquals(false, testTask.getIsDone());
        assertEquals(true, testTask2.getIsDone());
    }

    @Test
    public void testToString() {
        assertEquals("[E][N] Have lunch with John (at: 2/10/2019 2-4pm)", testTask.toString());
        assertEquals("[E][Y] Have lunch with John (at: 2/10/2019 2-4pm)", testTask2.toString());
    }
}