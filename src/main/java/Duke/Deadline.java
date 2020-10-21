package duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDate by;

    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }
    public Deadline(String description, char type,LocalDate by) {
        super(description,type);
        this.by = by;
    }
    public Deadline(String description, char type,LocalDate by,boolean isDone) {
        super(description,type,isDone);
        this.by = by;
    }
    @Override
    public String toString() {
        return "["+this.type+"] " + this.getStatusIcon() + " " + this.description + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
    public String printToFIle(){
        return this.type+"|" + (isDone ? "1" : "0") + "|" + this.description + "|" + by;
    }
}