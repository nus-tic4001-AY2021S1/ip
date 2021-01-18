package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * Contains the methods for user to delete task.
 */
public class DeleteCommand extends Command {
    private final String fullCommand;

    /**
     * Initializes a <code>DeleteCommand</code> object.
     *
     * @param fullCommand User's full input string.
     */
    public DeleteCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    /**
     * Executes the delete task command.
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
        String taskDescription;
        try {
            taskDescription = tasks.getTask(tasks.getSearchResultIndex(taskIndex)).toString();
            tasks.removeTask(tasks.getSearchResultIndex(taskIndex));
            tasks.setIsInitialized(false);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task index is invalid.");
        }
        storage.saveTasks(tasks);
        ui.printRemovedTask(tasks.getSize(), taskDescription);
    }
}