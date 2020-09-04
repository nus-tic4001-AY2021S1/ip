package Task;

public class Deadlines extends Tasks{
    private String deadline;

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
