package duke.commands;

import duke.parser.Parser;
import duke.util.Storage;
import duke.util.TaskList;
import duke.exceptions.DukeException;
import duke.ui.Ui;

import java.time.LocalDateTime;


/** .
 * Executes a event command.
 */
public class EventCommand extends Command {
    private String taskDescription;
    private  LocalDateTime formatDateTime;

    /** .
     * Constructs a EventCommand.
     *  @param input The strings contains keywords.
     */
    public EventCommand(String input) {
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

        int previousTaskSize = taskList.size();
        taskList.add(Parser.createEvent(input));
        int subsequentTaskSize = taskList.size();
        assert (previousTaskSize + 1 == subsequentTaskSize);

        return String.format(
                "Got it. I've added this task:\n%s\nNow you have %s tasks in the list.",
                Parser.createEvent(input), taskList.size()
        );
    }



}
