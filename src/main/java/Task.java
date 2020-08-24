public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        //return tick or X symbol based on isDone value
        return (isDone ? "\u2713" : "\u2718");
    }

    public void setDone(boolean isDone) {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[T][" + getStatusIcon() + "] " + description;
    }
}