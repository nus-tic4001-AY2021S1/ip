package duke.task;// Organize the classes into suitable duke.Tasks packages.

import duke.command.TaskException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * This Deadline class extends from task object.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
public class Deadline extends Task {

    protected LocalDate by;

    /**
     * entity deadline.
     *
     * @param description tasks' description
     * @param by          tasks' deadline time
     */
    public Deadline(String description, String by) throws TaskException {
        super(description);
        try {
            this.by = LocalDate.parse(by);
        } catch (DateTimeParseException e) {
            throw new TaskException("\nThe by field should be in yyyy-MM-dd HHmm format.");
        }
    }


    /**
     * get user command description of by.
     *
     * @return by
     */
    public String getBy() {
        return by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }


    /**
     * override the to string method.
     *
     * @return user command Deadline to "[D]"
     */
    public String toString() {
        return "[D]" + super.printDescription() + " (by: " + getBy() + ")";
    }

}
