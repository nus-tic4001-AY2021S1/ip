package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Contains the methods for user to list all tasks.
 */
public class ListCommand extends Command {
    /**
     * Executes the list all tasks command.
     *
     * @param tasks List of <code>Task</code> objects.
     * @param ui <code>Ui</code> object for displaying user interactions.
     * @param storage <code>Storage</code> object for loading and saving user data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.setIsInitialized(true);
        tasks.clearSearchResultIndexes();
        for (int i = 0; i < tasks.getSize(); i++) {
            tasks.addSearchResultIndex(i);
        }
        ui.printTasks(tasks);
    }
}
