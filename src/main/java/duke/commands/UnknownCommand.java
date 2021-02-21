package duke.commands;

import duke.util.Storage;
import duke.util.TaskList;
import duke.ui.Ui;

/** .
 * Executes a unknown command.
 */
public class UnknownCommand extends Command {

    /** .
     * Constructs a UnknownCommand.
     *  @param input The strings contains keywords.
     */
    public UnknownCommand(String input) {
        super(input);
    }

    /** .
     * Executes a unknown command and returns a response.
     *
     * @param taskList Contains the tasks.
     * @param ui Displays information to the user.
     * @param storage Reads and stores data into memory.
     * @return Message to users.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage)  {
        return String.format(
                "OOPS!!! I'm sorry, but I don't know what that means :-(");
    }


}
