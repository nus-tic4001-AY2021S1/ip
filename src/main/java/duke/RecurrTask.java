package duke;



public class RecurrTask extends Task {

    protected String type;
    protected String memo;

    public RecurrTask(String description, String type) {
        super(description);
        this.type = type;
    }

    public RecurrTask(String description, String type, String memo) {
        super(description);
        this.type = type;
        this.memo = memo;
    }

    @Override
    public String toString() {
        //return "[E]" + "[" + this.getStatusIcon() + "] " +  this.description + " (at: " + on + ")";
        return type + " - " + this.description;
    }
}
