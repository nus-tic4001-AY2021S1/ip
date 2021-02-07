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
                return "It appears that you have no tasks yet, so you can't delete any!\r"
                    + "Perhaps you should start creating one?";
            }
            if (line.isEmpty()) {
                return "You almost typed a proper delete command, but you missed out the number!\r"
                    + "Please type in the 'delete <task index number>' format.";
            }
            int index = Integer.parseInt(line);
            String message = ui.printTaskRemoved(tasks, index);
            tasks.remove(index);
            database.updateDatabase(tasks);
            return message;

        } catch (IOException e) {
            return e.getMessage();
        } catch (NumberFormatException e) {
            return
                "I'm sorry, but the list goes numerically.\rPerhaps you could type a number for the index?";
        } catch (IndexOutOfBoundsException e) {
            return "It appears that you only have " + tasks.size() + " task(s) in your list,\r"
                + "perhaps you might want to try typing an index number from 1 to " + tasks.size() + " instead?";
        }
    }
}