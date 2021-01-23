package duke.tasks;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTest {
    private Todo task1 = new Todo("To try out Todo");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime formatDateTime = LocalDateTime.parse("2020-10-14 22:00", formatter);
    private Event task2 = new Event("To try out Event", formatDateTime);



    @Test
    void testGetDescription() {
        assertEquals("To try out Todo", task1.getDescription());
        assertEquals("To try out Event", task2.getDescription());
    }


    // test default done status, before any changes
    @Test
    void testIsDoneBefore() {
        assertFalse(task1.isDone());
        assertFalse(task2.isDone());
    }


    // test updated done status, after the setDone changes
    @Test
    void testIsDoneAfter() {
        task1.setDone();
        task2.setDone();
        assertTrue(task1.isDone());
        assertTrue(task2.isDone());
    }

}