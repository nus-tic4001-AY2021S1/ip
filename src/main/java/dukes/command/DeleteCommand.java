package dukes.command;

import dukes.storage.Storage;
import dukes.tasks.Task;
import dukes.tasks.TaskList;
import dukes.Ui;
import dukes.exception.DukeException;

/**
 * Create a DeleteCommand. It removes user's task from the list.
 */
public class DeleteCommand extends Command {
    public DeleteCommand(String input ) {
        super.input = input;
    }

    /**
     * Adds a delete task from list with a specific index if index is valid, save the task to user's list.
     *
     * @param input  The strings contains keywords and index number.
     * @param tasks   TaskList to be appended.
     * @param ui      UI to interact with user.
     * @param storage Storage to read and write files and temporary store in hard disk.
     * @throws DukeException If user key in a number that is not in the TaskList.
     */
    @Override
    public String execute(String input, TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (input.isEmpty() || input.length() < 7 || input.trim().equals("")) {
                throw new DukeException("OOPS!!! Please refer to [Help] to key in Correct Format.\n");
            }
            int index = Ui.indexDetails(input);
            Task deletedTask = tasks.list.remove(index);
            storage.saveTaskFile(tasks.list);
            return ui.printDeleteMessage(deletedTask, tasks.list.size());
        } catch (DukeException e) {
            return (e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("OOPS!!! There is no specific task number to delete.");
        }
    }
}
