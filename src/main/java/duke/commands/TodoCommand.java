package duke.commands;

import duke.exceptions.DukeException;
import duke.parser.Parser;
import duke.util.Storage;
import duke.util.TaskList;
import duke.tasks.Task;
import duke.tasks.Todo;
import duke.ui.Ui;

/** .
 * Executes a todo command.
 */
public class TodoCommand extends Command {

    /** .
     * Constructs a TodoCommand.
     *  @param input The strings contains keywords.
     */
    public TodoCommand(String input) {
        super(input);
    }


    /** .
     * Executes a find command and returns a response.
     *
     * @param taskList Contains the tasks.
     * @param ui Displays information to the user.
     * @param storage Reads and stores data into memory.
     * @return Message to users.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {

        int previousTaskSize = taskList.size();
        taskList.add(Parser.createTodo(input));
        int subsequentTaskSize = taskList.size();
        assert (previousTaskSize + 1 == subsequentTaskSize);

        return String.format(
                "Got it. I've added this task:\n%s\nNow you have %s tasks in the list.",
                Parser.createTodo(input), taskList.size()
        );
    }



}
