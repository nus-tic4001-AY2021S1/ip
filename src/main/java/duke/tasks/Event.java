package duke.tasks;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDateTime dueDateTime;


    /** .
     * Creating an object of Event class
     *
     * @param description A String that holds the description of a task
     * @param dueDateTime          A LocalDateTime that holds the event date or time
     */
    public Event(String description, LocalDateTime dueDateTime) {
        super(description);
        this.dueDateTime = dueDateTime;

    }


    /** .
     * Gets the Event duration.
     *
     * @return getDueDateTime This Event duration/duedate (BY)
     */
    public LocalDateTime getDueDateTime() {

        return dueDateTime;
    }


    /** .
     * A method to get the Task data as formatted string to display task type [E], task status and task description
     *
     * @return a formatted String of task type [E], task status and task description
     */

    @Override
    public String toString() {

        //Create formatter
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
        //Get formatted String
        String formattedDate = fomatter.format(dueDateTime);
        return "[E]" + super.toString() + " (at: " + formattedDate + ")";
    }


}
