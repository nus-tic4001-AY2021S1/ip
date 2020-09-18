package duke;

import duke.tasks.Deadline;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeadlineTest {
    @Test
    public void Deadline() {
        Deadline deadline1 = new Deadline("borrow book", "today 6am");
        Deadline deadline2 = new Deadline("read book", "this week");
        Deadline deadline3 = new Deadline("return book", "next monday");

        assertEquals("[D][✘] borrow book (by: today 6am)", deadline1.toString());
        assertEquals("[D][✘] read book (by: this week)", deadline2.toString());
        assertEquals("[D][✘] return book (by: next monday)", deadline3.toString());
    }
}
