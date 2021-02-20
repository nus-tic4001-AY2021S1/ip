import duke.storage.Storage;
import duke.ui.Ui;
import org.junit.jupiter.api.Test;
import duke.command.DeadlineCommand;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeadlineCommandTest {
    @Test
    public void deadlineCommandTest() {
        Ui ui = new Ui();
        ArrayList commandName = new ArrayList();
        Storage storage = new Storage("data/duke.txt", commandName);
        String input = "--deadline --description haha --date 12/12/2001 1800 --email xxx@hotmail.com";
        //new DoneCommand(input,ui, storage, commandName);
        DeadlineCommand deadlineCommand = new DeadlineCommand(input, ui, storage, commandName);
        assertEquals(deadlineCommand.execute(), "This is a deadline Task has been added."
               + "\nDescription: haha\nDate: 12/12/2001 1800 \nEmail: xxx@hotmail.com");
    }

}