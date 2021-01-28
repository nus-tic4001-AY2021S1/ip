package duke.commands;

import duke.tasks.Task;
import duke.util.Storage;
import duke.util.TaskList;
import duke.ui.Ui;

public class DoneCommand extends Command {

    public DoneCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        String selectedTask = input;


        // checking if the task number is given and empty string or null
        if (selectedTask.trim().equals("")) {
            throw new NullPointerException("TASK NUM is Empty/Null: Returning to Main Menu");
        }

        int taskIndex = Integer.parseInt(selectedTask) - 1;
        if (taskIndex < 0 || taskIndex > taskList.size()) {
            throw new ArrayIndexOutOfBoundsException(
                    "TASK NUM cannot be found in the task list: Returning to Main Menu");
        }
        Task task = taskList.get(taskIndex);
        task.setDone();
        return String.format(
                "Nice! I've marked this task as done:\n%s",task);





    }

    @Override
    public String toString() {
        return "done <task taskIndex>";
    }







}