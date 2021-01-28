package duke;

import dukes.tasks.ToDo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    public void toDo() {
        ToDo todo = new ToDo("return book");
        assertEquals("[T][X] return book", todo.toString());
        assertEquals("T | 0 | return book", todo.toWriteFile());
    }
}

