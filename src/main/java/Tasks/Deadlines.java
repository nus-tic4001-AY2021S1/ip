package Tasks;

public class Deadlines extends Task {
    private String deadline;

    public Deadlines(String taskDescription, String deadline) {
        super(taskDescription);
        super.type = "[D]";
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + deadline + ")";
    }
}
