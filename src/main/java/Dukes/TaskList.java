package Dukes;

import java.util.ArrayList;

/**
 * Create a TaskList to store Task objects.
 */
public class TaskList {
    protected ArrayList<Task> tasks = new ArrayList<Task>(100);
    public ArrayList<Task> list = new ArrayList<Task>();

    public TaskList() {

    }

    public TaskList(ArrayList<String> load) {
    }

    public boolean isEmpty() {
        return false;
    }

}




