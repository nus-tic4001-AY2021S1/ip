package Tasks;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineTest {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    LocalDate formatDate = LocalDate.parse("2020-10-14", formatter);
    private Tasks.Deadline task = new Deadline("To try out Event",formatDate);


    @Test
    void getDueDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expectedValue=  LocalDate.parse("2020-10-14",formatter);
        assertEquals(expectedValue, task.getDueDate());
    }



    @Test
    void testToString() {
        assertEquals("[D][✘] To try out Event (by: 2020年10月14日星期三)", task.toString());
    }
}