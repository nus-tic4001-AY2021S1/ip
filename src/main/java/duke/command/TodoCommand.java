package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Contains the methods for user to add todo task.
 */
public class TodoCommand extends Command {
    private final String fullCommand;

    /**
     * Initializes a <code>TodoCommand</code> object.
     *
     * @param fullCommand User's full input string.
     */
    public TodoCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    /**
     * Executes the add todo command.
     *
     * @param tasks List of <code>Task</code> objects.
     * @param ui <code>Ui</code> object for displaying user interactions.
     * @param storage <code>Storage</code> object for loading and saving user data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.addTask(Parser.createTodo(fullCommand));
        tasks.setIsInitialized(false);
        storage.saveTasks(tasks);
        ui.printAddedTask(tasks);
    }
}
