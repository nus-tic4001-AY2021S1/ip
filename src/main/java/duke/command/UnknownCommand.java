package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

public class UnknownCommand extends Command {
    @Override
    public void execute(TaskList tasks, ArrayList<Integer> taskListIndexes, Ui ui, Storage storage) {
        ui.printError("I'm sorry, I don't know what that means.");
    }
}
