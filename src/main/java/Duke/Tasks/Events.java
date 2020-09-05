package Duke.Tasks;

public class Events extends Task {
    private String eventTime;

    public Events(String taskDescription, String eventTime) {
        super(taskDescription);
        super.taskType = "[E]";
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + eventTime + ")";
    }

    @Override
    public String toSavingString(){
        return super.toSavingString()+"|"+eventTime;
    }
}
