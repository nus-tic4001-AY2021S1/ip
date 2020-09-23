import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Event extends Task {
    protected boolean isDone;
    protected LocalDate at;

    public Event(String description, LocalDate at){
        super(description);
        this.at = at;
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
    public String getAt(){
        return this.at.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
    @Override
    public String toString(){
        return "[E]" + super.toString() + " (at: " + getAt() + ")";
    }
}
