package duke.commands;

import java.io.IOException;
import duke.database.Database;
import duke.exception.DukeException;
import duke.task.TaskList;
import duke.task.Todo;
import duke.ui.Ui;

/**
 * A command to create a simple Todo task.
 */

public class TodoCommand extends Command {
    public static final String word = "todo";

    public TodoCommand(String line, TaskList tasks, Ui ui, Database database) {
        super(line, tasks, ui, database);
    }

    @Override
    public String execute()  {
        try {
            if (line.isEmpty()) {
                return ui.printRed("It seems that you missed out the task description!\n"
                    + "Please type in the 'todo <something>' format.");
            }
            line = "[Todo]     " + line;
            tasks.add(new Todo(line));
            database.updateDatabase(tasks);
            return ui.printTaskAdded(tasks);

        } catch (IOException e) {
            return ui.printRed(e.getMessage());
        }
    }
}