package dukes.tasks;

/**
 * deadline task description /by specific date and time  e.g. return book by 12/12/2019 1800.
 *
 */
public class Deadline extends Task {
    protected String by;


    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by:" + by  + ")";
    }

    @Override
    public String toWriteFile() {
        return "D | " + getFileStatusIcon() + " | " + description + " | " + by;

    }
}

