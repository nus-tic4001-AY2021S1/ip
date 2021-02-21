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
        if(memo != null) {
            return type + " - " + this.description + " (Memos :" + this.memo + ")";
        } else {
            return type + " - " + this.description;
        }

    }
}
