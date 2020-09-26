package duke;

import duke.Deadline;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeadlineTest {
    @Test
    public void Deadline() {

        Deadline deadline1 = new Deadline("read book", "2020-09-26");
        Deadline deadline2 = new Deadline("return book", "2020-10-05");

        assertEquals("[D][✘] read book (by: Sep 26 2020)", deadline1.toString());
        assertEquals("[D][✘] return book (by: Oct 05 2020)", deadline2.toString());
    }
}