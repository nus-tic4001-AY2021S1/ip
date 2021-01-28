package duke.commands;

import duke.util.TaskList;
import duke.ui.Ui;
import java.util.StringJoiner;
import duke.util.Storage;



public class ListCommand extends Command {
    public ListCommand(String input) {
        super(input);
    }


    /** .
     * creating an Task object
     */

    /**
     * A method to list done all the tasks from the list and show the list to user.
     * Show the message to user and notify the user that "Here are the tasks in your list"
      */
    public void executeCommand() {
        Ui.showMessage("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            Ui.showMessage((i + 1) + "." + taskList.get(i).toString());
        }
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        StringJoiner response = new StringJoiner("\n");
        for (int i = 0; i < taskList.size(); i++) {
            response.add(String.format("%d.%s", i + 1, taskList.get(i)));
        }
        return response.toString().isEmpty()
                ? "You have no tasks at the moment :)"
                : response.toString();
    }

    @Override
    public String toString() {
        return "list";
    }


}