package Dukes.command;

import Dukes.Storage;
import Dukes.Task;
import Dukes.TaskList;
import Dukes.Ui;
/**
 * Create an AddCommand. It adds tasks to user's list.
 */
public class AddCommand extends Command {
    public AddCommand(Task task) {
        super.task = task;
    }

    /**
     * Adds a single task to user's list.
     *
     * @param tasks TaskList to be appended.
     * @param ui UI to interact with user.
     * @param storage Storage to read and write files and temporary store in hard disk.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.list.add(task);
        ui.printAddedMessage(task, tasks.list.size());
    }
}
