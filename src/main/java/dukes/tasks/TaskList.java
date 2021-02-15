package dukes.tasks;

import java.util.ArrayList;

/**
 * Create a TaskList to store Task objects.
 */
public class TaskList {
    protected ArrayList<Task> tasks = new ArrayList<>(100);
    public ArrayList<Task> list = new ArrayList<>();


    public TaskList() {

    }

    public TaskList(ArrayList<Task> load) {
        for (Task task : load) {
            tasks.add(task);
            list.add(task);
        }
    }

}




