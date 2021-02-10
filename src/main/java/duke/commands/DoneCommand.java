package duke.commands;

import java.io.IOException;
import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A command to set a particular task as completed.
 */

public class DoneCommand extends Command {
    public static final String word = "done";

    public DoneCommand(String line, TaskList tasks, Ui ui, Database database) {
        super(line, tasks, ui, database);
    }

    @Override
    public String execute()  {
        try {
            if (tasks.size() == 0) {
                return "You don't have any tasks you dolt, so you can't complete any!\r"
                    + "Go create one first!";
            }
            if (line.isEmpty()) {
                return "You almost typed a proper done command, but you missed out the number!\r"
                    + "Type in the 'done <task index number>' format, you dolt!";
            }
            int index = Integer.parseInt(line);
            tasks.get(index - 1).setDone();
            database.updateDatabase(tasks);
            return ui.printTaskCompleted(index, tasks);

        } catch (IOException e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return
                "Type a number for the index, you fool!";
        } catch (IndexOutOfBoundsException e) {
            return "You only have " + tasks.size() + " task(s) in your list,\r"
                + "why can't you type an index number from 1 to " + tasks.size() + "?";
        }
    }
}
