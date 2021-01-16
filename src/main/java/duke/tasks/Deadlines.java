package duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task {
    private LocalDate deadline;

    /**
     * @param taskDescription description of the deadline task
     * @param deadline deadline time of the deadline task
     * create a deadline task
     */
    public Deadlines(String taskDescription, String deadline) {
        super(taskDescription);
        super.taskType = "[D]";
        this.deadline = LocalDate.parse(deadline, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
    }

    @Override
    public String toSavingString() {
        return super.toSavingString() + "|" + deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }
}
