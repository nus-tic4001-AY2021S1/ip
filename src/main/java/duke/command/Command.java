package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

public abstract class Command {
    public abstract void execute(
            TaskList tasks, ArrayList<Integer> taskListIndexes, Ui ui, Storage storage) throws DukeException;

    public boolean isBye() {
        return false;
    }
}
