package duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Todo {
    protected LocalDate at;

    public Event(String description, String at) {
        super(description);
        this.at = LocalDate.parse(at);
    }

    public String toString() {
        return "[E]" + "[" + getStatusIcon() + "]" + " " + getDescription() + " (at: " + getAt() + ")";
    }

    public String getAt() {
        return at.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    public String getAtForFile() {
        return at.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public boolean isEquals(Event toCompare) {
        if (this.at.equals(toCompare.getAt())) {
            return super.isEquals(toCompare);
        }
        return false;
    }
}
