package duke;

import java.util.ArrayList;

/**
 * A <code>TaskList</code> class manages the in-memory task list.
 * It contains an ArrayList that stores individual <code>Task</code> objects and methods
 * to perform operations such as adding and deleting task from the Task List.
 */
public class TaskList {

    private ArrayList<Task> tasks = new ArrayList<>();

    /**
     * Instantiate a <code>TaskList<Task></code> object.
     *
     * @return <code>TaskList<Task></code> object.
     */
    public TaskList() {
    }

    /**
     * Instantiate a <code>TaskList<Task></code> object.
     *
     * @param tasks List of <code>Task</> objects.
     * @return <code>TaskList<Task></code> object.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     *  Get a <code>Task<Task></code> object from the <code>TaskList</code>.
     *
     *  @param index Index of Task in the <code>TaskList</code>.
     *  @return <code>Task<Task></code> object.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     *  Add a task to the <code>TaskList<Task></code> object.
     *
     * @param t <code>Task</code> object.
     */
    public void addTask(Task t) {
        tasks.add(t);
    }

    /**
     *  Remove a <code>Task</code> object from the <code>TaskList</code>.
     *
     *  @param index Index of a <code>Task</code> in <code>List<Task></code>.
     *  @throws DukeException If index is invalid.
     */
    public void removeTask(int index) throws DukeException {
        try {
            tasks.remove(tasks.get(index));
        } catch(IndexOutOfBoundsException e) {
            throw new DukeException("Invalid index");
        }
    }

    /**
     *  Get size of a <code>TaskList<Task></code> object.
     *  @return Size of a <code>List<Task></code> object.
     */
    public int getSize() {
        return tasks.size();
    }
}
