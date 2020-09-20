package duke.command;

import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String fullCommand;

    public FindCommand(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    @Override
    public void execute(TaskList tasks, ArrayList<Integer> taskListIndexes, Ui ui, Storage storage) throws DukeException {
        String searchString = Parser.getSearchString(fullCommand).toLowerCase();
        taskListIndexes.clear();
        for (int i = 0; i < tasks.getSize(); i++) {
            String taskDescription = tasks.getTask(i).getDescription().toLowerCase();
            if (taskDescription.contains(searchString)) {
                taskListIndexes.add(i);
            }
        }
        ui.printFilteredTasks(tasks, taskListIndexes);
    }
}
