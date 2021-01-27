package duke.task;

/**
 * Represents a task that a user wants to do. A <code>Task</code> object has a
 * description string and a boolean that indicates whether the task is done. This
 * class defines the common behaviour that can be inherited by subclasses with specific
 * implementation of a task.
 */
public abstract class Task {
    private final String description;
    private boolean isDone;

    /**
     * Initializes a <code>Task</code> object.
     *
     * @param description Description of a <code>Task</code> object.
     */
    public Task(String description) {
        this.description = description;
        isDone = false;
    }
    
    /**
     * Initializes a <code>Task</code> object.
     *
     * @param description Description of a <code>Task</code> object.
     * @param isDone Completion status of a <code>Task</code> object.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * Gets the description of a <code>Task</code> object.
     * @return Description of a <code>Task</code> object.
     */

    public String getDescription() {
        return description;
    }

    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Gets the status icon of a <code>Task</code> object.
     * @return Status icon of a <code>Task</code> object.
     */
    public String getStatusIcon() {
        //return tick or X symbol based on isDone value
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Sets the completion status of a <code>Task</code> object to done.
     *
     */
    public void setDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }
}