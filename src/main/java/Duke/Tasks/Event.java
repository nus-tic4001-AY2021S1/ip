package Duke.Tasks;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Event extends Task {
    // A String that holds the event date or time
    protected String at;


    protected LocalDateTime dueDateTime;


    /**
     * Creating an object of Event class
     *
     * @param description A String that holds the description of a task
     * @param dueDateTime          A LocalDateTime that holds the event date or time
     */
    public Event(String description, LocalDateTime dueDateTime) {
        super(description);
        this.dueDateTime=dueDateTime;

    }


    /**
     * A method to set the due date of a task
     * @param dueDateTime The due date of the task as yyyy-MM-dd HH:mm
     * @throws DateTimeException if given date is a past date
     */
    protected void setDueDateTime (LocalDateTime dueDateTime) throws DateTimeException {
//        // Throw DateTimeException if past date is given
//        if (dueDate.compareTo(LocalDate.now())<0) {
//            throw new DateTimeException("Past Date not allowed");
//        }

        //Ensure dueDate is saved as yyyy-MM-dd
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.dueDateTime = LocalDateTime.parse(dueDateTime.format(formattedDate));

    }




    /**
     * Gets the Event duration.
     *
     * @return getDueDateTime This Event duration/duedate (BY)
     */
    public LocalDateTime getDueDateTime() {

        return dueDateTime;
    }




    /**
     * A method to get the Task data as formatted string to display task type [E], task status and task description
     *
     * @return a formatted String of task type [E], task status and task description
     */

    @Override
    public String toString() {

        //Create formatter
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
        //Get formatted String
        String formattedDate = FOMATTER.format(dueDateTime);
        return "[E]" + super.toString() + " (at: " + formattedDate + ")";
    }


}
