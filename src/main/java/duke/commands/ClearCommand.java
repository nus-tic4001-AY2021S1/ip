package duke.commands;

import duke.util.Storage;
import duke.util.TaskList;
import duke.tasks.Task;
import duke.ui.Ui;

public class ClearCommand extends Command {

    public ClearCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {

        taskList.clear();
        return String.format(
                "All the tasks in the Task List have been cleared. Thanks");
    }


}
