package duke.task;

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

    /**
     * Instantiate an <code>Event</code> object.
     *
     * @param description Description of an <code>Event</code> object.
     * @param at Start and End time of an <code>Event</code> object.
     * @param isDone Completion status of an <code>Event</code> object.
     * @return <code>Event</code> object.
     */
    public Event(String description, String at, boolean isDone) {
        super(description, isDone);
        this.at = at;
    }

    /**
     * Get the start/end time of an <code>Event</code> object.
     *
     *  @return Start/End time of an <code>Event</code> object.
     */
    public String getAt() {
        return at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}