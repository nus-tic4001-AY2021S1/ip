package duke.task;

import java.util.ArrayList;

import duke.exception.DukeException;

/**
 * Manages the in-memory task list. It contains an ArrayList that stores
 * individual <code>Task</code> objects and methods to perform operations
 * such as adding and deleting task from the Task List.
 */
public class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();
    private final ArrayList<Integer> searchResultIndexes = new ArrayList<>();
    private boolean isInitialized = false;

    /**
     * Initializes a <code>TaskList</code> object.
     */
    public TaskList() {
    }

    /**
     * Instantiate a <code>TaskList</code> object.
     *
     * @param tasks List of <code>Task</code> objects.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Get a <code>Task</code> object from the <code>TaskList</code>.
     *
     * @param index Index of Task in the <code>TaskList</code>.
     * @return <code>Task<</code> object.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Add a task to the <code>TaskList</code> object.
     *
     * @param t <code>Task</code> object.
     */
    public void addTask(Task t) {
        tasks.add(t);
    }

    /**
     * Remove a <code>Task</code> object from the <code>TaskList</code>.
     *
     * @param index Index of a <code>Task</code> in <code>List</code>.
     * @throws DukeException If index is invalid.
     */
    public void removeTask(int index) throws DukeException {
        try {
            tasks.remove(tasks.get(index));
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Invalid index");
        }
    }

    /**
     * Get size of a <code>TaskList</code> object.
     * @return Size of a <code>List</code> object.
     */
    public int getSize() {
        return tasks.size();
    }

    public void clearSearchResultIndexes() {
        searchResultIndexes.clear();
    }

    public void addSearchResultIndex(int searchResultIndex) {
        searchResultIndexes.add(searchResultIndex);
    }

    public ArrayList<Integer> getSearchResultIndexes() {
        return searchResultIndexes;
    }

    public int getSearchResultIndex(int resultIndex) {
        return searchResultIndexes.get(resultIndex);
    }

    public void setIsInitialized(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }

    public boolean getIsInitialized() {
        return isInitialized;
    }
}
