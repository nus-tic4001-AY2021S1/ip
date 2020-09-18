package Duke.Commands;

import Duke.Tasks.Task;
import Duke.TaskList;

import java.util.ArrayList;
/**
 * An abstract Command Class
 */
public abstract class Command {
    // An array list of task objects
    private ArrayList<Task> taskList;

    /**
     * creating an Task object
     */
    public Command() {
        taskList = TaskList.getList();
    }

    public abstract void executeCommand(); // create abstract


}
