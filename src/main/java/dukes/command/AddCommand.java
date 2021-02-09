package dukes.command;

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
     * Adds a Deadline/ Event/ Todo task to the task list and save the list to disk and display to user.
     * @param tasks TaskList to be appended.
     * @param ui UI to interact with user.
     * @param storage Storage to read and write files,temporary save and store in hard disk.
     * @return
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.list.add(task);
        return ui.printAddedMessage(task, tasks.list.size());
    }
}
