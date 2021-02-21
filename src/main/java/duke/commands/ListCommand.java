package duke.commands;

import duke.util.TaskList;
import duke.ui.Ui;
import java.util.StringJoiner;
import duke.util.Storage;


/** .
 * Executes a list command.
 */
public class ListCommand extends Command {

    /** .
     * Constructs a ListCommand.
     */
    public ListCommand(String input) {
        super(input);
    }


    /** .
     * Executes a list command and returns a response.
     *
     * @param taskList Contains the tasks.
     * @param ui Displays information to the user.
     * @param storage Reads and stores data into memory.
     * @return Message to users.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        StringJoiner response = new StringJoiner("\n");
        for (int i = 0; i < taskList.size(); i++) {
            response.add(String.format("%d.%s", i + 1, taskList.get(i)));
        }
        return response.toString().isEmpty()
                ? "You have no tasks at the moment :)"
                : response.toString();
    }


}