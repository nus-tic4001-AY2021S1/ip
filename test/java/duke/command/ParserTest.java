package duke.command;

import duke.task.Todo;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    public void getCommandWord() {
        assertEquals("todo", Parser.getCommand("todo read book"));
        assertEquals("deadline", Parser.getCommand("deadline return book /by next Friday"));
        assertEquals("exit", Parser.getCommand("exit"));
    }
}
