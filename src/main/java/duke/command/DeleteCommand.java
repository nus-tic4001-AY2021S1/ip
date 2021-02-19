package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * A command to delete task.
 */

public class DeleteCommand extends Command {
    private Storage storage;

    public static final String word = "--delete";

    public DeleteCommand(String line, Ui ui, Storage storage, ArrayList commandName) {
        super(line, ui, storage, commandName);
    }

    @Override
    public String execute() {

        try {

            String[] obj = line.split(" ", 2);

            if (commandName.isEmpty()) {
                return "<<No data in the database>>";
            } else {
                String clean = obj[1].replaceAll("\\D+", "");
                int num = Integer.parseInt(clean);
                if (num <= commandName.size()) {
                    int num1 = num - 1;
                    commandName.remove(num1);
                    return commandName.get(num1).toString() + " has been deleted";
                } else {
                    return "<<Invalid Input, There are only " + commandName.size() + " tasks>>";
                }
            }
        } catch (NumberFormatException ex) {
            return "<<Please enter a numeric input>>";
        }
    }


}
