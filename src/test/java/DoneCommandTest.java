import duke.command.DoneCommand;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DoneCommandTest {
    @Test
    public void doneCommandTest() {
        Parser parser = new Parser();
        Ui ui = new Ui();
        ArrayList commandName = new ArrayList();
        Storage storage = new Storage("data/duke.txt", commandName);
        String input = "--done gdfd";
        //new DoneCommand(input,ui, storage, commandName);
        DoneCommand doneCommand = new DoneCommand(input, ui, storage, commandName);
        assertEquals(doneCommand.execute(), "<<No data in the database>>");
    }


}
