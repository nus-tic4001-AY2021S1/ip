package duke.tasks;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static org.junit.jupiter.api.Assertions.assertEquals;

class DeadlineTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    LocalDate formatDate = LocalDate.parse("2020-10-14", formatter);
    private duke.tasks.Deadline task = new Deadline("To try out Event",formatDate);


    @Test
    void getDueDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expectedValue = LocalDate.parse("2020-10-14",formatter);
        assertEquals(expectedValue, task.getDueDate());
    }


    /**
     *COMMENTED OUT STUFF HERE
     *AND HERE
     * //    @Test
     * //    void testToString() {
     * //        assertEquals("[D][✘] To try out Event (by: Wednesday, October 14, 2020)", task.toString());
     * //    }
     */



}