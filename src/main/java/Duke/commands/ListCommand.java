package Duke.Commands;

import Duke.TaskList;
import Duke.Tasks.Task;
import Duke.Ui;

import java.util.ArrayList;

public class ListCommand {

    // An array list of task objects
    private ArrayList<Task> taskList;

    /**
     * creating an Task object
     */
    public ListCommand() {
        taskList = TaskList.getList();
    }



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


}