package Tasks;

import Tasks.Event;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime formatDateTime = LocalDateTime.parse("2020-10-14 22:00", formatter);
    private Tasks.Event task2 = new Event("To try out Event", formatDateTime);

    @Test
    public void getDescription() {
              assertEquals("To try out Event", task2.getDescription());
    }

    @Test
    public void isDone() {
         assertFalse(task2.isDone());
    }


    @Test
    void setDueDateTime() {
    }

    @Test
    void testGetDueDateTime() {
        LocalDateTime expectedValue=  LocalDateTime.parse("2020-10-14T22:00");
        assertEquals(expectedValue, task2.getDueDateTime());
    }

    @Test
    void testToString() {
        assertEquals("[E][✘] To try out Event (at: 星期三, 10月 14, 2020 22:00:00 下午)", task2.toString());
    }
}