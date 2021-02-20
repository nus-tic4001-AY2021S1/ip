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

    @Override
    public String toString() {

        String outputMsg = "[E]" + "[" + this.getStatusIcon() + "] " +  this.description + " (at: " + on + ")";

        if (memo != null) {
            return outputMsg + " (Memos : " + this.memo + ")";
        } else {
            return outputMsg;
        }

    }

}
