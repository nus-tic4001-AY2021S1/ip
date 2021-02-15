package dukes.command;

import dukes.storage.Storage;
import dukes.tasks.Task;
import dukes.tasks.TaskList;
import dukes.Ui;
import dukes.exception.DukeException;
/**
 * Represents a command.
 * Parent class of all other types of commands to perform some action.
 */

public abstract class Command {
    protected Task task;
    protected String keyWord;
    protected String input;

    public abstract String execute(String input, TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Checks if this object is an <code>ExitCommand</code>.
     * @return Whether this command is an exit command.
     */
    public boolean isExit() {
        return false;
    }

}
