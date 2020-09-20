package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

public class DeleteCommand extends Command {
    private String fullCommand;

    public DeleteCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    @Override
    public void execute(TaskList tasks, ArrayList<Integer> taskListIndexes, Ui ui, Storage storage) throws DukeException {
        int taskIndex = Parser.getTaskIndex(fullCommand);
        String taskDescription;
        try {
            taskDescription = tasks.getTask(taskListIndexes.get(taskIndex)).toString();
            tasks.removeTask(taskListIndexes.get(taskIndex));
        } catch (NullPointerException e) {
            throw new DukeException("Please run the list or find command first.");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task index is invalid.");
        }
        storage.saveTasks(tasks);
        ui.printRemovedTask(tasks.getSize(), taskDescription);
    }
}
