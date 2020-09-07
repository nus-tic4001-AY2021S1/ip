package duke;

/**
 * Represents a task that a user wants to do. An <code>Event</code> object has a
 * description string, a boolean that indicates whether the task is done, and an at string
 * that indicates the start and end time of the task.
 */
public class Event extends Task {
    private String at;

    /**
     * Instantiate an <code>Event</code> object.
     *
     * @param description Description of an <code>Event</code> object.
     * @param at Start and End time of an <code>Event</code> object.
     * @return <code>Event</code> object.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
