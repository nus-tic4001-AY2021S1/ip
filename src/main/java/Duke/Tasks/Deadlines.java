package Duke.Tasks;

public class Deadlines extends Task {
    private String deadline;

    /**
     * @param taskDescription description of the deadline task
     * @param deadline deadline time of the deadline task
     * create a deadline task
     */
    public Deadlines(String taskDescription, String deadline) {
        super(taskDescription);
        super.taskType = "[D]";
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + deadline + ")";
    }
}
