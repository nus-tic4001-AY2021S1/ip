package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Contains the methods for user to exit Duke.
 */
public class ByeCommand extends Command {
    /**
     * Executes the exit program command.
     *
     * @param tasks List of <code>Task</code> objects.
     * @param ui <code>Ui</code> object for displaying user interactions.
     * @param storage <code>Storage</code> object for loading and saving user data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printGoodbye();
    }

    /**
     * Returns true so that Duke will exist after this command is executed.
     */
    @Override
    public boolean isBye() {
        return true;
    }
}