package duke;



public class RecurrTask extends Task {

    protected String type;

    public RecurrTask(String description, String type) {
        super(description);
        this.type = type;
    }

    @Override
    public String toString() {
        //return "[E]" + "[" + this.getStatusIcon() + "] " +  this.description + " (at: " + on + ")";
        return type + " - " + this.description;
    }
}
