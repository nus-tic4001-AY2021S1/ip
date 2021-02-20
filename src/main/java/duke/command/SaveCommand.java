package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * A command to save the recent change task from array into txt file.
 */
public class SaveCommand extends Command {

    public static final String word = "--save";


    public SaveCommand(String line, Ui ui, Storage storage, ArrayList commandName) {
        super(line, ui, storage, commandName);

    }

    @Override
    public String execute() {

        storage.saveToFile(commandName);
        return ui.saveMsg();
    }
}
