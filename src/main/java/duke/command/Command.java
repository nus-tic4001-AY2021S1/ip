package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Represents a command that a user wants to execute. A <code>Command</code> object contains
 * methods need to execute the user's command . This class defines the common behaviour that
 * can be inherited by subclasses with specific implementation of a Command.
 */
public abstract class Command {
    /**
     * Executes the user's command.
     *
     * @param tasks List of <code>Task</code> objects.
     * @param ui <code>Ui</code> object for displaying user interactions.
     * @param storage <code>Storage</code> object for loading and saving user data.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Returns false to prevent Duke from exiting after the command.
     * Subclasses should override this method to return true if Duke
     * needs to exit after the command.
     */
    public boolean isBye() {
        return false;
    }
}
