package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

public class DoneCommand extends Command {
    private String fullCommand;

    public DoneCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    @Override
    public void execute(TaskList tasks, ArrayList<Integer> taskListIndexes, Ui ui, Storage storage) throws DukeException {
        int taskIndex = Parser.getTaskIndex(fullCommand);
        try {
            tasks.getTask(taskListIndexes.get(taskIndex)).setDone(true);
        } catch (NullPointerException e) {
            throw new DukeException("Please run the list or find command first.");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task index is invalid.");
        }
        storage.saveTasks(tasks);
        ui.printDoneTask(tasks.getTask(taskListIndexes.get(taskIndex)));
    }
}
