public class Todo extends Task {
    private boolean isDone;

    public Todo(String description) {
        super(description);
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[T][" + getStatusIcon() + "] " + getDescription();
    }
}