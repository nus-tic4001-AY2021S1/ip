package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{
    protected LocalDate at;

    public Event(String description, LocalDate at) {
        super(description);
        this.at = at;
    }

    public Event(String description, char type,LocalDate at) {
        super(description,type);
        this.at = at;
    }

    public Event(String description, char type,LocalDate at,boolean isDone) {
        super(description,type,isDone);
        this.at = at;
    }
    @Override
    public String toString() {
        return "["+this.type+"] " + this.getStatusIcon() + " " + this.description + " (at: " + at.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
    public String printToFIle(){
        return this.type+"|" + (isDone ? "1" : "0") + "|" + this.description + "|" + at;
    }
}
