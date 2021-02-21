package duke.commands;

import duke.ui.Ui;
import duke.util.Storage;
import duke.util.TaskList;

import java.util.StringJoiner;

/** .
 * Executes a sort command.
 */
public class SortCommand extends Command {

    /** .
     * Constructs a SortCommand.
     *  @param input The strings contains keywords.
     */
    public SortCommand(String input) {
        super(input);
    }

    /** .
     * Executes a sort command and returns a response.
     *
     * @param taskList Contains the tasks.
     * @param ui Displays information to the user.
     * @param storage Reads and stores data into memory.
     * @return Message to users.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {

        taskList.sort();
        StringJoiner response = new StringJoiner("\n");
        for (int i = 0; i < taskList.size(); i++) {
            response.add(String.format("%d.%s", i + 1, taskList.get(i)));
        }

        return String.format(
                "Hi, your tasks have been sorted based on Task Status and Description. Thanks\n%s",response.toString());

    }


}
