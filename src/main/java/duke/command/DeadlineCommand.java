package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

public class DeadlineCommand extends Command {
    private String fullCommand;

    public DeadlineCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    @Override
    public void execute(TaskList tasks, ArrayList<Integer> taskListIndexes, Ui ui, Storage storage) throws DukeException {
        tasks.addTask(Parser.createDeadline(fullCommand));
        storage.saveTasks(tasks);
        ui.printAddedTask(tasks);
    }
}
