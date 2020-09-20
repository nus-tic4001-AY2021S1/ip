package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeleteCommand extends Command {
    private final String fullCommand;

    public DeleteCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

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
