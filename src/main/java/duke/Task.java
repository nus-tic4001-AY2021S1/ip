package duke;

/**
 * Represents a task that a user wants to do. A <code>Task</code> object has a
 * description string and a boolean that indicates whether the task is done. This
 * class defines the common behaviour that can be inherited by subclasses with specific
 * implementation of a task.
 */
public abstract class Task {
    private String description;
    private boolean isDone;

    /**
     * Constructor for a <code>Task</code> object.
     *
     * @param description Description of a <code>Task</code> object.
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    /**
     * Get the description of a <code>Task</code> object.
     * @return Description of a <code>Task</code> object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the status icon of a <code>Task</code> object.
     * @return Status icon of a <code>Task</code> object.
     */
    public String getStatusIcon() {
        //return tick or X symbol based on isDone value
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Set the completion status of a <code>Task</code> object to done.
     *
     * @param isDone Completion status of a <code>Task</code> object.
     */
    public void setDone(boolean isDone) {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }
}
