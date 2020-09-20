package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class FindCommand extends Command {
    private final String fullCommand;

    public FindCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String searchString = Parser.getSearchString(fullCommand).toLowerCase();
        tasks.setIsInitialized(true);
        tasks.clearSearchResultIndexes();
        for (int i = 0; i < tasks.getSize(); i++) {
            String taskDescription = tasks.getTask(i).getDescription().toLowerCase();
            if (taskDescription.contains(searchString)) {
                tasks.addSearchResultIndex(i);
            }
        }
        ui.printFilteredTasks(tasks);
    }
}
