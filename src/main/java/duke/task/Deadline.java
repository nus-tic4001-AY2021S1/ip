package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import duke.exception.DukeException;

/**
 * Represents a task that a user wants to do. A <code>Deadline</code> object has a
 * description string, a boolean that indicates whether the task is done, and a by string
 * that indicates the deadline of the task.
 */
public class Deadline extends Task {
    private final LocalDateTime by;

    /**
     * Initializes a <code>Deadline</code> object.
     *
     * @param description Description of a <code>Deadline</code> object.
     * @param by Deadline of a <code>Deadline</code> object.
     * @throws DukeException If datetime is in the wrong format.
     */
    public Deadline(String description, String by) throws DukeException {
        super(description);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
            this.by = LocalDateTime.parse(by, formatter);
        } catch (DateTimeParseException e) {
            throw new DukeException("The by field should be in yyyy-MM-dd HHmm format. E.g. 2020-12-25 1800");
        }
    }

    /**
     * Initializes a <code>Deadline</code> object.
     *
     * @param description Description of a <code>Deadline</code> object.
     * @param by Deadline of a <code>Deadline</code> object.
     * @param isDone Completion status of a <code>Deadline</code> object.
     * @throws DukeException If datetime is in the wrong format.
     */
    public Deadline(String description, String by, boolean isDone) throws DukeException {
        super(description, isDone);
        try {
            this.by = LocalDateTime.parse(by);
        } catch (DateTimeParseException e) {
            throw new DukeException("The by field should be in yyyy-MM-dd HHmm format. E.g. 2020-12-25 1800");
        }
    }

    /**
     * Gets the deadline of a <code>Deadline</code> object.
     *
     * @return Deadline of a <code>Deadline</code> object.
     */
    public String getBy() {
        return by.toString();
    }

    /**
     * Gets the String representation of a <code>Deadline</code> object.
     *
     * @return String representation of a <code>Deadline</code> object.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString()
                + " (by: " + by.format(DateTimeFormatter.ofPattern("d MMM yyyy h:mma")) + ")";
    }
}
