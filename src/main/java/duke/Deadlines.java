package duke;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task {
    protected LocalDate deadline;
    protected LocalTime timeline;
    protected String memo;

    public Deadlines(String description, LocalDate by) {
        super(description);
        this.deadline = by;
    }

    public Deadlines(String description, LocalDate by, String memo) {
        super(description);
        this.deadline = by;
        this.memo = memo;
    }

    public Deadlines(String description, LocalDate by, LocalTime time) {
        super(description);
        this.deadline = by;
        this.timeline = time;
    }

    public Deadlines(String description, LocalDate by, LocalTime time, String memo) {
        super(description);
        this.deadline = by;
        this.timeline = time;
        this.memo = memo;
    }

    @Override
    public String toString() {

        String outputMsg = "[D][" + this.getStatusIcon() + "] " + this.description + " (by: "
            + deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

        if (timeline != null) {
            outputMsg = outputMsg + " " + timeline.format(DateTimeFormatter.ofPattern("kk:mm"));
        }
        if (memo != null) {
            outputMsg = outputMsg + ") (Memos : " + memo;
        }

        outputMsg += ")";
        return outputMsg;
    }

}
