package Dukes;

import Dukes.Tasks.ToDo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void ToDoTest() {
        ToDo todo = new ToDo("return book");
        assertEquals("[T][✘] return book", todo.toString());
        assertEquals("T | 0 | return book", todo.toWriteFile());
    }

}

