import duke.command.DeadlineCommand;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeCheckerTest {

    @Test
    public void timeCheckerTest() {
        Parser parser = new Parser();
        Ui ui = new Ui();
        ArrayList commandName = new ArrayList();
        Storage storage = new Storage("data/duke.txt", commandName);
        String input = "--deadline --description haha --date 12/12/2001 --email xxx@hotmail.com";
        //new DoneCommand(input,ui, storage, commandName);
        DeadlineCommand deadlineCommand = new DeadlineCommand(input, ui, storage, commandName);
        assertEquals(deadlineCommand.execute(), "<<Invalid Date Format>>");
    }
}
