package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Contains the methods for user to mark task as done.
 */
public class DoneCommand extends Command {
    private final String fullCommand;

    /**
     * Initializes a <code>DoneCommand</code> object.
     *
     * @param fullCommand User's full input string.
     */
    public DoneCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    /**
     * Executes the mark task as done command.
     *
     * @param tasks List of <code>Task</code> objects.
     * @param ui <code>Ui</code> object for displaying user interactions.
     * @param storage <code>Storage</code> object for loading and saving user data.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (!(tasks.getIsInitialized())) {
            throw new DukeException("Please run the list or find command first.");
        }
        int taskIndex = Parser.getTaskIndex(fullCommand);
        try {
            tasks.getTask(tasks.getSearchResultIndex(taskIndex)).setDone();
            tasks.setIsInitialized(false);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task index is invalid.");
        }
        storage.saveTasks(tasks);
        ui.printDoneTask(tasks.getTask(tasks.getSearchResultIndex(taskIndex)));
    }
}
