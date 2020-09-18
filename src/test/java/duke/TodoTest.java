package duke;

import duke.tasks.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void ToDo() {

        Todo todo1 = new Todo("borrow book");
        Todo todo2 = new Todo("read book");
        Todo todo3 = new Todo("return book");

        assertEquals("[T][✘] borrow book", todo1.toString());
        assertEquals("[T][✘] read book", todo2.toString());
        assertEquals("[T][✘] return book", todo3.toString());
    }
}
