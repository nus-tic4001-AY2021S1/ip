package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class SortCommand extends Command {
    /**
     * Executes the sort tasks command.
     *
     * @param tasks List of <code>Task</code> objects.
     * @param ui <code>Ui</code> object for displaying user interactions.
     * @param storage <code>Storage</code> object for loading and saving user data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.sortTasks();
        storage.saveTasks(tasks);
        ui.printSortedTasks(tasks);
    }
}
