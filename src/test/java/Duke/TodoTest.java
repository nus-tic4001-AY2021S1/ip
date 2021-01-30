package Duke;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void ToDo() {

        Todo todo1 = new Todo("read book");
        Todo todo2 = new Todo("return book");

        assertEquals("[T][✘] read book", todo1.toString());
        assertEquals("[T][✘] return book", todo2.toString());
    }
}
