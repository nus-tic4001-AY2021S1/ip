package duke.task;

/**
 * Represents a task that a user wants to do. A <code>Todo</code> object has a
 * description string and a boolean that indicates whether the task is done.
 */
public class Todo extends Task {
    /**
     * Initializes a <code>Todo</code> object.
     *
     * @param description Description of a <code>Todo</code> object.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Initializes a <code>Todo</code> object.
     *
     * @param description Description of a <code>Todo</code> object.
     * @param isDone Completion status of a <code>Todo</code> object.
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
