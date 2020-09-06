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
     * Changes the deadline description of the task.
     * This may involve a lengthy legal process.
     *
     * @param by This deadline description (BY)
     */
    public void setBy(String by) {
        this.by = by;
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
     * A method to get the Task data as formatted string to display task type [D], task status and task description
     *
     * @return a formatted String of task type [D], task status and task description
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }


}
