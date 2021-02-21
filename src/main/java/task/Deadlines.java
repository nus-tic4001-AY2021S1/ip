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

    /**
     * @return a string of task with index, description and status
     */
    @Override
    public String saveToString() {
        String doneStatus = isDone ? "1" : "0";
        return type.charAt(1) + "|" + doneStatus + "|" + description + "|" + deadline;
    }
}
