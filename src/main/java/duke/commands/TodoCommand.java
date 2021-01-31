package duke.commands;

import duke.exceptions.DukeException;
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
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {

        String taskDetail;
        int len = input.split(" ").length; // to check who many words
        String[] lineArr = input.split(" ", 2);
        String commandFirstWord = input.split(" ")[0].toLowerCase();

        if (len > 1) {
            taskDetail = lineArr[1].trim();  // filter out the first words
        } else {
            throw new DukeException("OOPS!!! The description of a " + commandFirstWord + " cannot be empty.");
        }



        Task task = new Todo(taskDetail);
        int previousTaskSize = taskList.size();
        taskList.add(task);
        int subsequentTaskSize = taskList.size();
        assert (previousTaskSize + 1 == subsequentTaskSize);

        return String.format(
                "Got it. I've added this task:\n%s\nNow you have %s tasks in the list.",
                task, taskList.size()
        );
    }



}
