import duke.tasks.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;


public class TodoTest {

    @Test
    public void todoTest() {
        Todo todo = new Todo("Read Book", "12/12/12 1800", "haha@hotmail.com");
        assertEquals("[T][x] Read Book | 12/12/12 1800 | haha@hotmail.com", todo.toString());
    }
}
