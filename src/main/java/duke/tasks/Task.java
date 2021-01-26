package duke.tasks;

public abstract class Task {
    protected String description;

    public Task(String description) {
        this.description = description;
    }

    public abstract String getStatusIcon();

    public abstract void setDone();

    public abstract void setNotDone();

    public abstract boolean getIsDone();

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + getDescription();
    }
}
