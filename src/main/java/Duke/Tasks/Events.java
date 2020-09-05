package Duke.Tasks;

public class Events extends Task {
    private String eventTime;

    /**
     * @param taskDescription description of the event
     * @param eventTime the time of the event
     * To create a event task
     */
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
