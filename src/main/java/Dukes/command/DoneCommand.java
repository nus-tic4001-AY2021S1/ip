package Dukes.command;

import Dukes.Storage;
import Dukes.Tasks.TaskList;
import Dukes.Tasks.Task;
import Dukes.Ui;
import Dukes.Exceptions.DukeException;

/**
 * Represents a done command.
 * A <code>DoneCommand</code> object corresponds to a command to mark a <code>TaskList</code> object
 * in a <code>TaskList</code> as done.
 */
public class DoneCommand extends Command {
    /**
     * Constructor for <code>DoneCommand</code>.
     * @param index Index of object that is to be marked as done in a TaskList object.
     */
    public DoneCommand(int index) {
        super.index = index;
    }
    /**
     * Mark a task in the task list as done if specified index is valid, save the task list and display to user
     *
     * @param tasks TaskList to be appended.
     * @param ui UI to interact with user.
     * @param storage Storage to read and write files and temporary store in hard disk.
     * @throws <code>DukeException</code> If user key in a number that is not in the TaskList.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            Task doneTask = tasks.list.get(index).markAsDone();
            ui.printDoneMessage(doneTask);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please key in a number from the list");
        }
    }
}
