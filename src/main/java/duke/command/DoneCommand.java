package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;

import java.util.ArrayList;


/**
 * A command to mark a task to be done.
 */

public class DoneCommand extends Command {
    private Storage storage;
    public static final String word = "--done";

    public DoneCommand(String line, Ui ui, Storage storage, ArrayList commandName) {
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
                    String makeDone = commandName.get(num1).toString();
                    commandName.set(num1, makeDone.replace("x", "c"));
                    return makeDone.replace("x", "c") + " has been set to done";
                } else {
                    return "<<Invalid Input, There are only " + commandName.size() + " tasks>>";
                }
            }
        } catch (NumberFormatException ex) {
            return "<<Please enter a numeric input>>";
        }
    }

}
