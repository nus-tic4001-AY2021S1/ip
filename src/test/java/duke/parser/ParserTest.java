package duke.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import duke.exception.DukeException;

/**
 * JUnit tests for Parser class.
 */
public class ParserTest {
    @Test
    public void testGetCommand() {
        assertEquals("todo", Parser.getCommand("todo Eat breakfast"));
        assertEquals("", Parser.getCommand(""));
    }

    @Test
    public void testGetTaskIndex() throws DukeException {
        assertEquals(2, Parser.getTaskIndex("delete 3"));
        assertThrows(DukeException.class, () -> {
            Parser.getTaskIndex("delete");
        });
        assertThrows(DukeException.class, () -> {
            Parser.getTaskIndex("delete x");
        });
    }
}
