package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {
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
