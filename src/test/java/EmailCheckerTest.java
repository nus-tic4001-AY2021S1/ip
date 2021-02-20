import duke.command.DeadlineCommand;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmailCheckerTest {
    @Test
    public void emailCheckerTest() {
        Ui ui = new Ui();
        ArrayList commandName = new ArrayList();
        Storage storage = new Storage("data/duke.txt", commandName);
        String input = "--deadline --description haha --date 12/12/2001 1800 --email xxxhotmail.com";
        DeadlineCommand deadlineCommand = new DeadlineCommand(input, ui, storage, commandName);
        assertEquals(deadlineCommand.execute(), "<<Invalid Email Format>>");
    }
}