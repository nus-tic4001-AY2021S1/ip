package duke.commands;

import duke.parser.Parser;
import duke.util.Storage;
import duke.util.TaskList;
import duke.exceptions.DukeException;
import duke.ui.Ui;


/** .
 * Executes a DeadLine command.
 */
public class DeadLineCommand extends Command {


    /** .
     * Constructs a DeadLineCommand.
     *  @param input The strings contains keywords.
     */
    public DeadLineCommand(String input) {
        super(input);
    }


    /** .
     * Executes a DeadLine command and returns a response.
     *
     * @param taskList Contains the tasks.
     * @param ui Displays information to the user.
     * @param storage Reads and stores data into memory.
     * @return Message to users.
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {

        int previousTaskSize = taskList.size();
        taskList.add(Parser.createDeadline(input));
        int subsequentTaskSize = taskList.size();
        assert (previousTaskSize + 1 == subsequentTaskSize);


        return String.format(
                "Got it. I've added this task:\n%s\nNow you have %s tasks in the list.",
                Parser.createDeadline(input), taskList.size()
        );

    }


}
