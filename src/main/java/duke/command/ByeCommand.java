package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

public class ByeCommand extends Command {
    @Override
    public void execute(TaskList tasks, ArrayList<Integer> taskListIndexes, Ui ui, Storage storage) {
        ui.printGoodbye();
    }

    @Override
    public boolean isBye() {
        return true;
    }
}
