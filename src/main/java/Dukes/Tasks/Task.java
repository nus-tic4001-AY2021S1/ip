package Dukes.Tasks;

/**
 * Represents a Task.
 * Parent class of all other types of tasks.
 * A <code>Task</code> object corresponds to a task to be added to a <code>TaskList</code>.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;
    /**
     * Constructor for <code>Task</code>.
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    /**
     * Returns a tick icon if the task is completed and return a X icon if otherwise.
     * @return Icon to indicate status of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }
    public String getFileStatusIcon() {
        return (isDone ? "1" : "0");
    }
    /**
     * Sets the task as done.
     */
    public Task markAsDone() {
        this.isDone = true;
        return this;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public String toWriteFile() {
        return "T | " + getFileStatusIcon() + " | " + description;
    }

}



