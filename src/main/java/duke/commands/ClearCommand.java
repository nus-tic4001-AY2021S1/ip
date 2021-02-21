package duke.commands;

import duke.util.Storage;
import duke.util.TaskList;
import duke.ui.Ui;

public class ClearCommand extends Command {
    /**
     * Constructs a ClearCommand.
     * @param input It contains user input.
     */
    public ClearCommand(String input) {
        super(input);
    }

    /**
     * Executes a clear command and returns a response.
     *
     * @param taskList Contains the current tasks.
     * @param ui Responsible for displaying information to the user.
     * @param storage Reads and stores data into memory.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {

        taskList.clear();
        return String.format(
                "All the tasks in the Task List have been cleared. Thanks");
    }


}
