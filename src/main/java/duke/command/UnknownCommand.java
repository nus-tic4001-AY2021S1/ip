package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Contains the method to inform users if the command is invalid.
 */
public class UnknownCommand extends Command {
    /**
     * Executes the invalid input command.
     *
     * @param tasks List of <code>Task</code> objects.
     * @param ui <code>Ui</code> object for displaying user interactions.
     * @param storage <code>Storage</code> object for loading and saving user data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printError("I'm sorry, I don't know what that means.");
    }
}
