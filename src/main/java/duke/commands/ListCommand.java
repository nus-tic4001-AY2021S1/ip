package duke.commands;

import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A command to print out all tasks in the list.
 */
public class ListCommand extends Command {
    public static final String word = "list";

    public ListCommand(TaskList tasks, Ui ui) {
        super(tasks, ui);
    }

    @Override
    public String execute()  {
        if (tasks.size() == 0) {
            return "You don't have any tasks you dolt, so there's no list!\r"
                + "Go create a task first!";
        }
        String total = "Here's the list of your tasks, you peasant.\r\r";
        for (int i = 0; i < tasks.size(); i++) {
            total = total.concat((i + 1) + ". " + tasks.get(i).getDescription()) + "\r\r";
        }
        return total;
    }
}
