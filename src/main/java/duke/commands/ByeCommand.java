package duke.commands;

import duke.ui.Ui;
import duke.util.Storage;
import duke.util.TaskList;

/** .
 * Executes a Bye command.
 */
public class ByeCommand extends Command {
    /**
     * Constructs a ByeCommand.
     * @param input It contains user input.
     */
    public ByeCommand(String input) {
        super(input);
    }

    /**
     * Executes a bye command and returns a response.
     *
     * @param taskList Contains the current tasks.
     * @param ui Responsible for displaying information to the user.
     * @param storage Reads and stores data into memory.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        return "Bye. Hope to see you again soon!";
    }



}
