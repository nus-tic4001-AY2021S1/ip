package task;

public class Deadlines extends Tasks {
    private String deadline;

    /**
     * @param description Deadline description
     * @param deadline deadline timee
     */
    public Deadlines(String description, String deadline) {
        super(description);
        super.type = "[D]";
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return super.toString() + "(by: " + deadline + ")";
    }
}
