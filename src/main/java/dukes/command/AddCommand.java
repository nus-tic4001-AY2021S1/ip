package dukes.command;

import dukes.exception.DukeException;
import dukes.storage.Storage;
import dukes.tasks.Task;
import dukes.tasks.TaskList;
import dukes.Ui;


/**
 * Create an AddCommand. It will add a Deadline, Event, todo task to the user list and save it.
 */

public class AddCommand extends Command {

    public AddCommand(Task task) {
        super.task = task;
    }

    /**
     * Adds a todo task to the task list and save the list to disk and display to user.
     *
     * @param input  The strings contains keywords and descriptions.
     * @param tasks   TaskList to be appended.
     * @param ui      UI to interact with user.
     * @param storage Storage to read and write files,temporary save and store in hard disk.
     */
    @Override
    public String execute(String input, TaskList tasks, Ui ui, Storage storage) {
        try {
            if (input.length() < 6) {
                throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
            }
            tasks.list.add(task);
            storage.saveTaskFile(tasks.list);
            return ui.printAddedMessage(task, tasks.list.size());
        } catch (DukeException e) {
            return (e.getMessage());
        }
    }
}
