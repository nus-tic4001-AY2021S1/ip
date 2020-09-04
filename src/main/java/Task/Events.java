package Task;

public class Events extends Tasks {
    private String eventDateTime;

    public Events(String description, String eventDateTime) {
        super(description);
        super.type = "[E]";
        this.eventDateTime = eventDateTime;
    }

    @Override
    public String toString() {
        return super.toString() + "(at: " + eventDateTime + ")";
    }

}
