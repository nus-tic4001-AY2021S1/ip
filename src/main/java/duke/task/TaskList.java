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
     * Initializes a <code>TaskList</code> object.
     *
     * @param tasks List of <code>Task</code> objects.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gets a <code>Task</code> object from the <code>TaskList</code> object.
     *
     * @param index Index of Task in the <code>TaskList</code> object.
     * @return <code>Task<</code> object.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Adds a task to the <code>TaskList</code> object.
     *
     * @param t <code>Task</code> object.
     */
    public void addTask(Task t) {
        tasks.add(t);
    }

    /**
     * Removes a <code>Task</code> object from the <code>TaskList</code> object.
     *
     * @param index Index of a <code>Task</code> in the <code>TaskList</code> object.
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
     * Gets the size of a <code>TaskList</code> object.
     *
     * @return Size of a <code>List</code> object.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     *  Sorts a <code>TaskList</code> object.
     */
    public void sortTasks() {
        tasks.sort(new TaskListSorter());
    }

    /**
     * Adds the index of a <code>Task</code> object that contains the search keyword.
     *
     * @param searchResultIndex Index of a <code>Task</code> object in the <code>TaskList</code> object.
     */
    public void addSearchResultIndex(int searchResultIndex) {
        searchResultIndexes.add(searchResultIndex);
    }

    /**
     * Clears the indexes of <code>Task</code> objects that contain the search keyword.
     */
    public void clearSearchResultIndexes() {
        searchResultIndexes.clear();
    }

    /**
     * Gets the indexes of <code>Task</code> objects that contain the search keyword.
     *
     * @return Indexes of <code>Task</code> objects that contain the search keyword.
     */
    public ArrayList<Integer> getSearchResultIndexes() {
        return searchResultIndexes;
    }

    /**
     * Gets the index of a <code>Task</code> object that contains the search keyword.
     *
     * @return Index of <code>Task</code> object that contains the search keyword.
     */
    public int getSearchResultIndex(int resultIndex) {
        return searchResultIndexes.get(resultIndex);
    }

    /**
     * Sets the initialization status of the <code>TaskList</code> object.
     *
     * @param isInitialized Initialization status of the <code>TaskList</code> object.
     */
    public void setIsInitialized(boolean isInitialized) {
        this.isInitialized = isInitialized;
    }

    /**
     * Gets the initialization status of a <code>TaskList</code> object.
     *
     * @return Initialization status of a <code>List</code> object.
     */
    public boolean getIsInitialized() {
        return isInitialized;
    }
}
