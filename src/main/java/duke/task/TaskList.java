package duke.task;

import java.util.ArrayList;
/**
 * Responsible for methods regarding the task list.
 * This class will use an ArrayList inside it.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public int size() {
        return tasks.size();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void remove(int index) {
        tasks.remove(index - 1);
    }

    public Task get(int index) {
        return tasks.get(index);
    }
}