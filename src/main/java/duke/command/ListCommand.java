package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, ArrayList<Integer> taskListIndexes, Ui ui, Storage storage) {
        taskListIndexes.clear();
        for (int i = 0; i < tasks.getSize(); i++) {
            taskListIndexes.add(i);
        }
        ui.printTasks(tasks);
    }
}
