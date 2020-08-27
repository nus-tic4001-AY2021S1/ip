package Tasks;

public class Event extends Task {
    // A String that holds the event date or time
    protected String at;

    /**
     * Creating an object of Event class
     *
     * @param description A String that holds the description of a task
     * @param at          A String that holds the event date or time
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }


    /**
     * A method to get the Task data as formatted string to display task type [E], task status and task description
     *
     * @return a formatted String of task type [E], task status and task description
     */

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }


}
