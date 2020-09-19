package duke;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task {
    protected String by, time;
    protected LocalDate deadline;
    protected LocalTime timeline;

    public Deadlines(String description, LocalDate by) {
        super(description);
        this.deadline = by;
    }
    public Deadlines(String description, LocalDate by, LocalTime time ) {
        super(description);
        this.deadline = by;
        this.timeline = time;
    }

    //@Override
    public String toString() {
        //return "[D]" + super.toString() + " (by: " + by + ")";
        if(timeline != null) {
            return "[D]" + "[" + this.getStatusIcon() + "] " +  this.description + " (by: " +
                    deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " " +
                    timeline.format(DateTimeFormatter.ofPattern("kk:mm")) + ")";
        } else {
            return "[D]" + "[" + this.getStatusIcon() + "] " +  this.description + " (by: " +
                    deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
        }

    }

}
