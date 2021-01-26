package duke.commands;

import java.io.IOException;
import duke.database.Database;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A command to set a particular task as completed.
 */

public class DeleteCommand extends Command {
    public static final String word = "delete";

    public DeleteCommand(String taskDescription, TaskList tasks, Ui ui, Database database) {
        super(taskDescription, tasks, ui, database);
    }

    @Override
    public String execute()  {
        try {
            if (tasks.size() == 0) {
                return ui.printRed("It appears that you have no tasks yet, so you can't delete any!\n"
                    + "Perhaps you should start creating one?");
            }
            if (line.isEmpty()) {
                return ui.printRed("You almost typed a proper delete command, but you missed out the number!\n"
                    + "Please type in the 'delete <task index number>' format.");
            }
            int index = Integer.parseInt(line);
            String message = ui.printTaskRemoved(tasks, index);
            tasks.remove(index);
            database.updateDatabase(tasks);
            return message;

        } catch (IOException e) {
            return ui.printRed(e.getMessage());
        } catch (NumberFormatException e) {
            return ui.printRed(
                "I'm sorry, but the list goes numerically.\nPerhaps you could type a number for the index?");
        } catch (IndexOutOfBoundsException e) {
            return ui.printRed("It appears that you only have " + tasks.size() + " task(s) in your list,\n"
                + "perhaps you might want to try typing an index number from 1 to " + tasks.size() + " instead?");
        }
    }
}