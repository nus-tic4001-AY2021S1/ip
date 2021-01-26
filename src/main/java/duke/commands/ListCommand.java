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
    public void execute() {
        if (tasks.size() == 0) {
            ui.printBorderlines("It appears that you have no tasks! Perhaps you should start creating one?");
            return;
        }
        String total = "Here are the tasks that you currently have!\n";
        for (int i = 0; i < tasks.size(); i++) {
            total = total.concat((i + 1) + ". " + tasks.get(i).getDescription()) + "\n";
        }
        ui.printBorderlines(total);
    }
}
