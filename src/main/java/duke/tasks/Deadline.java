package duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * To test Deadline, please run DeadlineTest.
 */
public class Deadline extends Todo {
    protected LocalDate by;

    public Deadline(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
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
}
