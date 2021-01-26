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
    public DeleteCommand(int index) {
        super.index = index;
    }

    /**
     * Adds a delete task from list with a specific index if index is valid, save the task to user's list.
     *
     * @param tasks   TaskList to be appended.
     * @param ui      UI to interact with user.
     * @param storage Storage to read and write files and temporary store in hard disk.
     * @throws DukeException If user key in a number that is not in the TaskList.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            Task deletedTask = tasks.list.remove(index);
            ui.printDeleteMessage(deletedTask, tasks.list.size());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please key in a number from the list");
        }
    }
}
