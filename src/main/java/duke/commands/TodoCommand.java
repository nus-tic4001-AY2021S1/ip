package duke.commands;

import duke.util.Storage;
import duke.util.TaskList;
import duke.tasks.Task;
import duke.tasks.Todo;
import duke.ui.Ui;

public class TodoCommand extends Command {
    public TodoCommand(String input) {
        super(input);
    }


    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {

        Task task = new Todo(input);
        int previousTaskSize = taskList.size();
        taskList.add(task);
        int subsequentTaskSize = taskList.size();
        assert (previousTaskSize + 1 == subsequentTaskSize);

        return String.format(
                "Got it. I've added this task:\n%s\nNow you have %s tasks in the list.",
                task, taskList.size()
        );
    }

    @Override
    public String toString() {
        return "todo <description>";
    }

}
