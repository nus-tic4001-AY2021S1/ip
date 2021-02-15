package dukes.tasks;

/**
 * Represents an event task that start at a specific date and time. eg. event join team /at 12/12/2019 1800.
 */
public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at:" + at + ")";
    }

    @Override
    public String toWriteFile() {
        return "E | " + getFileStatusIcon() + " | " + description + " | " + at;
    }
}

