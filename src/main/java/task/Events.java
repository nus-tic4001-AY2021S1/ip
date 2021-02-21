package task;

public class Events extends Tasks {
    private String eventDateTime;

    /**
     * @param description event description
     * @param eventDateTime event date and time
     */
    public Events(String description, String eventDateTime) {
        super(description);
        super.type = "[E]";
        this.eventDateTime = eventDateTime;
    }

    @Override
    public String toString() {
        return super.toString() + "(at: " + eventDateTime + ")";
    }

    /**
     * @return a string of task with index, description and status
     */
    @Override
    public String saveToString() {
        String doneStatus = isDone ? "1" : "0";
        return type.charAt(1) + "|" + doneStatus + "|" + description + "|" + eventDateTime;
    }

}
