package duke.commands;

import duke.exceptions.DukeException;
import duke.tasks.Task;
import duke.util.Storage;
import duke.util.TaskList;
import duke.ui.Ui;

import java.util.Arrays;

import static duke.parser.Parser.getInputArray;

public class DoneCommand extends Command {

    public DoneCommand(String input) {
        super(input);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {

        String selectedTask;
        int len = input.split(" ").length; // to check who many words

        if (len > 1) {
            selectedTask =  input.split(" ")[1];
        } else {
            throw new DukeException("TASK NUM is Empty/Null/Invalid: Returning to Main Menu");
            // checking if the task number is given and empty string or null
        }


        // checking if the task number is given and empty string or null
        if (selectedTask.trim().equals("")) {
            throw new DukeException("TASK NUM is Empty/Null/Invalid: Returning to Main Menu");
        }

        int taskIndex = Integer.parseInt(selectedTask) - 1;
        if (taskIndex < 0 || taskIndex > taskList.size()) {
            throw new DukeException(
                    "TASK NUM cannot be found in the task list: Returning to Main Menu");
        }
        Task task = taskList.get(taskIndex);
        task.setDone();
        return String.format(
                "Nice! I've marked this task as done:\n%s",task);


    }



}