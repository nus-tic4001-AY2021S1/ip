package Dukes.command;

import Dukes.Storage;
import Dukes.Tasks.Task;
import Dukes.Tasks.TaskList;
import Dukes.Ui;
import Dukes.Exceptions.DukeException;
/**
 * Represents a command.
 * Parent class of all other types of commands to perform some action.
 */
public abstract class Command {

    protected Task task;
    protected int index;
    protected String keyWord;


    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Checks if this object is an <code>ExitCommand</code>.
     * @return Whether this command is an exit command.
     */
    public boolean isExit() {
        return false;
    }

}
