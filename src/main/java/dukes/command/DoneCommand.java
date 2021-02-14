package dukes.command;

import dukes.storage.Storage;
import dukes.tasks.Task;
import dukes.tasks.TaskList;
import dukes.Ui;
import dukes.exception.DukeException;

/**
 * Represents a done command.
 * A <code>DoneCommand</code> object corresponds to a command to mark a <code>TaskList</code> object
 * in a <code>TaskList</code> as done.
 */
public class DoneCommand extends Command {
    /**
     * Constructor for <code>DoneCommand</code>.
     * @param input  The strings contains keywords and index number
     */
    public DoneCommand(String input) {
        super.input = input;
    }
    /**
     * Mark a task in the task list as done if specified index is valid, save the task list and display to user.
     *
     * @param input  The strings contains keywords and index number
     * @param tasks TaskList to be appended.
     * @param ui UI to interact with user.
     * @param storage Storage to read and write files and temporary store in hard disk.
     * @throws DukeException If user key in a number that is not in the TaskList.
     */

    @Override
    public String execute(String input,TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (input.length() < 6 || input.isEmpty()) {
                throw new DukeException("OOPS!!! Please refer to [Help] to key in Correct Format.\n");
            }
            int toEdit = Ui.indexDetails(input);
            Task doneTask = tasks.list.get(toEdit).markAsDone();
            storage.saveTaskFile(tasks.list);
            return ui.printDoneMessage(doneTask);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! There is no specific task number in the list");
        }
    }
}
