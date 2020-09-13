package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task that a user wants to do. A <code>Deadline</code> object has a
 * description string, a boolean that indicates whether the task is done, and a by string
 * that indicates the deadline of the task.
 */
public class Deadline extends Task {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private LocalDateTime by;

    /**
     * Instantiate a <code>Deadline</code> object.
     *
     * @param description Description of a <code>Deadline</code> object.
     * @param by Deadline of a <code>Deadline</code> object.
     * @return <code>Deadline</code> object.
     */
    public Deadline(String description, String by) throws DukeException {
        super(description);
        try {
            this.by = LocalDateTime.parse(by, formatter);
        } catch (DateTimeParseException e) {
            throw new DukeException("The by field should be in yyyy-MM-dd HHmm format.");
        }
    }

    /**
     * Instantiate a <code>Deadline</code> object.
     *
     * @param description Description of a <code>Deadline</code> object.
     * @param by Deadline of a <code>Deadline</code> object.
     * @param isDone Completion status of a <code>Deadline</code> object.
     * @return <code>Deadline</code> object.
     */
    public Deadline(String description, String by, boolean isDone) throws DukeException {
        super(description, isDone);
        try {
            this.by = LocalDateTime.parse(by);
        } catch (DateTimeParseException e) {
            throw new DukeException("The by field should be in yyyy-MM-dd HHmm format.");
        }
    }

    /**
     * Get the deadline of a <code>Deadline</code> object.
     *
     *  @return Deadline of a <code>Deadline</code> object.
     */
    public String getBy() {
        return by.toString();
    }

    @Override
    public String toString() {
        return "[D]" + super.toString()
                + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm")) + ")";
    }
}