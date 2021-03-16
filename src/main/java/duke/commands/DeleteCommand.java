package duke.commands;

import duke.exceptions.DukeException;
import duke.parser.Parser;
import duke.util.Storage;
import duke.util.TaskList;
import duke.tasks.Task;
import duke.ui.Ui;

/** .
 * Executes a delete command.
 */
public class DeleteCommand extends Command {

    /** .
     * Constructs a DeleteCommand.
     *  @param input The strings contains keywords.
     */
    public DeleteCommand(String input) {
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
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {

        int taskIndex = Parser.getTaskIndex(input);
        if (taskIndex < 0 || taskIndex >= taskList.size()) {
            throw new DukeException(
                    "TASK NUM cannot be found in the task list: Returning to Main Menu");
        }

        int previousTaskSize = taskList.size();
        Task task = taskList.remove(taskIndex);
        int subsequentTaskSize = taskList.size();
        assert (previousTaskSize == subsequentTaskSize - 1);
        return String.format("Noted. I've removed this task:\n"
                + "%s\n" + "Now you have %d tasks in the list.", task, taskList.size());
    }


}
