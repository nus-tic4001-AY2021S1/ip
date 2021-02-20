package duke;

import duke.command.Command;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * A Personal Assistant Chatbot that helps a person to keep track of various things.
 *
 * @author Lin Binhui
 */

public class Duke {

    private final ArrayList commandName = new ArrayList();
    private final Storage storage = new Storage("/Users/linbinhui/biomindrepo/impala/data/duke.txt", commandName);

    Ui ui = new Ui();
    boolean isLoad = false;

    String getResponse(String input) {
        final Parser parser = new Parser();
        // load the current file
        if (isLoad == false) {
            storage.readFromFile();
            isLoad = true;
        }
        Command command = parser.parserInput(input, ui, storage, commandName);
        return command.execute();
    }

    String getWelcome() {
        return ui.welcome();
    }
}
