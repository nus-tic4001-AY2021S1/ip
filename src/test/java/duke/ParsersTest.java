package duke;

import dukes.command.Command;
import dukes.command.ExitCommand;
import dukes.parser.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParsersTest {

    @Test
    public void parseExit() {
        Parser exit = new Parser();
        Command command;
        try {
            command = Parser.parse("exit");
            assertTrue(command instanceof ExitCommand);
        } catch (Exception e) {
            fail("Should not shown thrown Exception.");
        }
    }

    @Test
    public void parseBye() {
        Parser bye = new Parser();
        Command command;
        try {
            command = Parser.parse("bye");
            assertTrue(command instanceof ExitCommand);
        } catch (Exception e) {
            fail("Should not shown thrown Exception.");
        }
    }
}
