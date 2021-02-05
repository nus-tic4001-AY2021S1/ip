package dukes.tasks;

import java.util.ArrayList;

/**
 * Create a TaskList to store Task objects.
 */
public class TaskList {
    protected ArrayList<Task> tasks = new ArrayList<>(100);
    public ArrayList<Task> list = new ArrayList<>();


    public TaskList(ArrayList<String> load) {
    }

    public TaskList() {

    }
}




