package Duke;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeadlineTest {
    @Test
    public void Deadline() {

        Deadline deadline1 = new Deadline("read book", LocalDate.parse("2020-09-26"));
        Deadline deadline2 = new Deadline("return book", LocalDate.parse("2020-09-26"));

        assertEquals("[D][✘] read book (by: Sep 26 2020)", deadline1.toString());
        assertEquals("[D][✘] return book (by: Oct 05 2020)", deadline2.toString());
    }
}