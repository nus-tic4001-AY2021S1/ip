package duke.tasks;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class Deadline extends Task {

    // The due date of the task as yyyy-mm-dd format
    protected LocalDate dueDate;

    /** .
     * Creating an object of Event class
     *
     * @param description A String that holds the description of a task
     * @param dueDate     A LocalDate that holds the deadline date.The due date of the task as yyyy-mm-dd format
     *
     */
    public Deadline(String description, LocalDate dueDate) {
        super(description);
        this.setDueDate(dueDate);

    }

    /** .
     * A method to get the due date of the task
     *
     * @return the due date of task as LocalDate object
     */
    public LocalDate getDueDate() {

        return dueDate;
    }

    /** .
     * A method to set the due date of a task
     *
     * @param dueDate The due date of the task as yyyy-mm-dd format
     * @throws DateTimeException if given date is a past date
     */
    protected void setDueDate(LocalDate dueDate) throws DateTimeException {
        //Ensure dueDate is saved as yyyy-MM-dd
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    /** .
     * A method to get the Task data as formatted string to display task type [D], task status and task description
     *
     * @return a formatted String of task type [D], task status and task description
     *     To format the date display to the users.
     *     LONG format:    April 3, 2019
     *     MEDIUM format:  Apr 3, 2019
     *     SHORT format:   4/3/19
     *     FULL format:    Wednesday, April 3, 2019
     */
    @Override
    public String toString() {

        String formattedDate = dueDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        return "[D]" + super.toString() + " (by: " + formattedDate + ")";
    }


}
