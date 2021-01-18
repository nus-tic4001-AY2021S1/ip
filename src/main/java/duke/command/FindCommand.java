package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Contains the methods for user to find tasks based on keywords.
 */
public class FindCommand extends Command {
    private final String fullCommand;

    /**
     * Initializes an <code>FindCommand</code> object.
     *
     * @param fullCommand User's full input string.
     */
    public FindCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    /**
     * Executes the find tasks command.
     *
     * @param tasks List of <code>Task</code> objects.
     * @param ui <code>Ui</code> object for displaying user interactions.
     * @param storage <code>Storage</code> object for loading and saving user data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String searchString = Parser.getSearchString(fullCommand).toLowerCase();
        String[] searchWords = searchString.split(" ");
        tasks.setIsInitialized(true);
        tasks.clearSearchResultIndexes();
        for (int i = 0; i < tasks.getSize(); i++) {
            String taskDescription = tasks.getTask(i).getDescription().toLowerCase();
            for (String searchWord : searchWords) {
                if (taskDescription.contains(searchWord.trim())) {
                    tasks.addSearchResultIndex(i);
                    break;
                }
            }
        }
        ui.printFilteredTasks(tasks);
    }
}