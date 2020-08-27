package Tasks;

public class Deadline extends Task {
    // A String that holds the deadline date
    protected String by;

    /**
     * Creating an object of Event class
     *
     * @param description A String that holds the description of a task
     * @param by          A String that holds the deadline date
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }


    /**
     * A method to get the Task data as formatted string to display task type [D], task status and task description
     *
     * @return a formatted String of task type [D], task status and task description
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }


}
