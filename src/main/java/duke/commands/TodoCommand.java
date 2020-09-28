package duke.commands;

import duke.database.Database;
import duke.exception.DukeException;
import duke.task.TaskList;
import duke.task.Todo;
import duke.ui.Ui;

import java.io.IOException;
/**
 * A command to create a simple Todo task.
 */
public class TodoCommand extends Command {
    public static final String word = "todo";

    public TodoCommand(String line, TaskList tasks, Ui ui, Database database) {
        super(line, tasks, ui, database);
    }

    @Override
    public void execute() {
        try {
            if (line.isEmpty()) {
                throw new DukeException("It seems that you missed out the task description!\n" +
                        "Please type in the 'todo <something>' format.");
            }
            line = "[Todo]     " + line;
            tasks.add(new Todo(line));
            ui.printTaskAdded(tasks);
            database.updateDatabase(tasks);

        } catch (DukeException | IOException e) {
            ui.printRedBorderlines(e.getMessage());
        }
    }
}