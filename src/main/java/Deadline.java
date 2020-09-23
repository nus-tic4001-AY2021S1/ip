import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Deadline extends Task {
    protected boolean isDone;
    protected LocalDate by;

    //constructor
    public Deadline(String description, LocalDate by){
        super(description);
        this.by = by;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public void markAsDone(){
        this.isDone = true;
    }
    public boolean getIsDone(){
        return this.isDone;
    }
    public String getBy(){
        return this.by.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + getBy() + ")";
    }
}
