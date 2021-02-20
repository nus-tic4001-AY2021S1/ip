package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;
import java.util.ArrayList;


/**
 * A command to find the keyword.
 */

public class FindCommand extends Command {

    public static final String word = "--find";

    public FindCommand(String line, Ui ui, Storage storage, ArrayList commandName) {
        super(line, ui, storage, commandName);
    }

    @Override
    public String execute() {


        if (commandName.isEmpty()) {
            return "<<No data in the database>>";
        } else {


            String[] obj = line.split(" ", 2);
            String output = "";
            String temp = "";
            int number = 0;
            for (Object task : commandName) {
                if (task.toString().contains(obj[1])) {
                    temp = ui.dataConverter(task.toString());
                    output = output.concat(number + 1 + "\n" + temp + "\r");
                } else {
                    output = "<<No matching.>>";
                }
                number++;
            }
            return output + "\nTotal has " + number + " matched found.";

        }
    }

}
