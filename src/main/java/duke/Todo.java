package duke;

/**
 * Represents a task that a user wants to do. A <code>Todo</code> object has a
 * description string and a boolean that indicates whether the task is done.
 */
public class Todo extends Task {
    /**
     * Instantiate a <code>Todo</code> object.
     *
     * @param description Description of a <code>Todo</code> object.
     * @return <code>Todo</code> object.
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}