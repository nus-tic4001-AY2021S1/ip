package duke.tasks;

import duke.DukeException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * To test Deadline, please run DeadlineTest.
 */
public class Deadline extends Todo {
    protected LocalDate by;

    public Deadline(String description, String by) throws DukeException {
        super(description);
        try {
            this.by = LocalDate.parse(by);
        } catch (DateTimeParseException e) {
            throw new DukeException("Date format is wrong, please use yyyy-mm-dd format.");
        }
    }

    public String toString() {
        return "[D]" + "[" + getStatusIcon() + "]" + " " + getDescription() + " (by: " + getBy() + ")";
    }

    public String getBy() {
        return by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    public String getByForFile() {
        return by.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public boolean isEquals(Object toCompare) {
        if (toCompare != null && toCompare.getClass() == getClass()) {
            if (this.by.equals(((Deadline) toCompare).by)) {
                return super.isEquals(toCompare);
            }
        }
        return false;
    }
}
