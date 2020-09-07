package duke;

/**
 * Represents a task that a user wants to do. A <code>Deadline</code> object has a
 * description string, a boolean that indicates whether the task is done, and a by string
 * that indicates the deadline of the task.
 */
public class Deadline extends Task {
    private String by;

    /**
     * Instantiate a <code>Deadline</code> object.
     *
     * @param description Description of a <code>Deadline</code> object.
     * @param by Deadline of a <code>Deadline</code> object.
     * @return <code>Deadline</code> object.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}