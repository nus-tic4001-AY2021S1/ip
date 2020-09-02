package duke.tasks;

public class Event extends Todo {
    protected String at;
    public Event(String description, String at){
        super(description);
        this.at = at;
    }
    public String toString(){
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
