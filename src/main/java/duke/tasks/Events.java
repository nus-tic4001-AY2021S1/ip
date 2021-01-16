package duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Events extends Task {
    private LocalDate eventTime;

    /**
     * @param taskDescription description of the event
     * @param eventTime the time of the event
     * To create a event task
     */
    public Events(String taskDescription, String eventTime) {
        super(taskDescription);
        super.taskType = "[E]";
        this.eventTime = LocalDate.parse(eventTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + eventTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    @Override
    public String toSavingString() {
        return super.toSavingString() + "|" + eventTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }
}
