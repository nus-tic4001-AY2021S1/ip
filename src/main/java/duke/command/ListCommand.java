package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;
import java.util.ArrayList;

/**
 * A command to list down all the tasks.
 */

public class ListCommand extends Command {


    public static final String word = "--list";

    public ListCommand(String line, Ui ui, Storage storage, ArrayList commandName) {
        super(line, ui, storage, commandName);
    }


    public String execute() {
        if (commandName.isEmpty()) {
            return "No data in the database";
        } else {
            int number = 1;
            String data = "";
            String temp = "";
            for (Object task : commandName) {
                temp = ui.dataConverter(task.toString());
                data = data.concat(number + "\n" + temp + "\r");
                number++;
            }
            return data;
        }
    }
}
