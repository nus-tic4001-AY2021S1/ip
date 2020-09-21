package duke.task;

import duke.exception.DukeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a task that a user wants to do. An <code>Event</code> object has a
 * description string, a boolean that indicates whether the task is done, an at string
 * that indicates the start datetime of the task, and a duration string that indicates
 * the duration of the task.
 */
public class Event extends Task {
    private final LocalDateTime at;
    private final int duration;

    /**
     * Instantiate an <code>Event</code> object.
     *
     * @param description Description of an <code>Event</code> object.
     * @param at Start datetime of an <code>Event</code> object.
     */
    public Event(String description, String at) throws DukeException {
        super(description);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
            String startDate = at.split(" ")[0].trim();
            String startTime = at.split(" ")[1].trim();
            String startDateTime = startDate + " " + startTime;
            this.at = LocalDateTime.parse(startDateTime, formatter);
            this.duration = Integer.parseInt(at.split(" ")[2].trim());
        } catch (DateTimeParseException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new DukeException("The at field should be in yyyy-MM-dd HHmm DURATION_IN_MINUTES format."
                    + " E.g. 2020-12-25 1800 60");
        }
    }

    /**
     * Instantiate an <code>Event</code> object.
     *
     * @param description Description of an <code>Event</code> object.
     * @param at Start datetime of an <code>Event</code> object.
     * @param duration Duration of an <code>Event</code> object.
     * @param isDone Completion status of an <code>Event</code> object.
     */
    public Event(String description, String at, String duration, boolean isDone) throws DukeException {
        super(description, isDone);
        try {
            this.at = LocalDateTime.parse(at);
            this.duration = Integer.parseInt(duration);
        } catch (DateTimeParseException e) {
            throw new DukeException("The at field should be in yyyy-MM-dd HHmm format. E.g. 2020-12-25 1800");
        }
    }

    /**
     * Get the start datetime of an <code>Event</code> object.
     *
     * @return Start datetime of an <code>Event</code> object.
     */
    public String getAt() {
        return at.toString();
    }

    public String getDuration() {
        return String.valueOf(duration);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (at: " + at.format(DateTimeFormatter.ofPattern("d MMM yyyy h:mma"))
                + " to "
                + at.plusMinutes(duration).format(DateTimeFormatter.ofPattern("d MMM yyyy h:mma"))
                + ")";
    }
}