package Tasks;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Deadline extends Task {


    // A String that holds the deadline date
    protected String by;


    // The due date of the task as yyyy-mm-dd format
    protected LocalDate dueDate;

    protected LocalDateTime dueDateTime;


    /**
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


    /**
     * Creating an object of Task class
     *
     * @param description A String that holds the description of a task
     */
    public Deadline(String description) {
        super(description);
    }

    /**
     * Gets the deadline description of the task.
     *
     * @return by This deadline description (BY)
     */
    public String getBy() {
        return by;
    }

    /**
     * Changes the deadline description of the task.
     * This may involve a lengthy legal process.
     *
     * @param by This deadline description (BY)
     */
    public void setBy(String by) {
        this.by = by;
    }

    /**
     * A method to get the due date of the task
     *
     * @return the due date of task as LocalDate object
     */
    public LocalDate getDueDate() {

        return dueDate;
    }

    /**
     * A method to set the due date of a task
     *
     * @param dueDate The due date of the task as yyyy-mm-dd format
     * @throws DateTimeException if given date is a past date
     */
    protected void setDueDate(LocalDate dueDate) throws DateTimeException {
//        // Throw DateTimeException if past date is given
//        if (dueDate.compareTo(LocalDate.now())<0) {
//            throw new DateTimeException("Past Date not allowed");
//        }

        //Ensure dueDate is saved as yyyy-MM-dd
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    /**
     * A method to get the Task data as formatted string to display task type [D], task status and task description
     *
     * @return a formatted String of task type [D], task status and task description
     * To format the date display to the users.
     * * LONG format:    April 3, 2019
     * * MEDIUM format:  Apr 3, 2019
     * * SHORT format:   4/3/19
     * * FULL format:    Wednesday, April 3, 2019
     */
    @Override
    public String toString() {

        String formattedDate = dueDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        return "[D]" + super.toString() + " (by: " + formattedDate + ")";
    }


}
