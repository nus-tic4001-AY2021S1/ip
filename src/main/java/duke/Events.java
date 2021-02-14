package duke;

public class Events extends Task {
    protected String on;
    protected String memo;

    public Events(String description, String on) {
        super(description);
        this.on = on;
    }

    public Events(String description, String on, String memo) {
        super(description);
        this.on = on;
        this.memo = memo;
    }

    //@Override
    public String toString() {
        //return "[E]" + super.toString() + " (at: " + on + ")";
        if (memo != null) {
            return "[E]" + "[" + this.getStatusIcon() + "] " +  this.description + " (at: " + on + ")"
                    + " (Memos : " + this.memo + ")";
        } else {
            return "[E]" + "[" + this.getStatusIcon() + "] " +  this.description + " (at: " + on + ")";
        }

    }

}
