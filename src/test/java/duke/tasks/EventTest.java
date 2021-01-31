package duke.tasks;

import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EventTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime formatDateTime = LocalDateTime.parse("2020-10-14 22:00", formatter);
    private duke.tasks.Event task2 = new Event("To try out Event", formatDateTime);

    @Test
    public void getDescription() {
        assertEquals("To try out Event", task2.getDescription());
    }

    @Test
    public void isDone() {
        assertFalse(task2.isDone());
    }




    @Test
    void testGetDueDateTime() {
        LocalDateTime expectedValue =  LocalDateTime.parse("2020-10-14T22:00");
        assertEquals(expectedValue, task2.getDueDateTime());
    }


    /**
     *COMMENTED OUT STUFF HERE
     *AND HERE
     * //    @Test
     * //    void testToString() {
     * //        assertEquals("[E][✘] To try out Event (at: Wednesday, Oct 14, 2020 22:00:00 PM)", task2.toString());
     * //    }
     */


}