package duke.tasks;

public class Todo extends Task {
    protected boolean isDone;

    public Todo(String description) {
        super(description);
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setDone() {
        this.isDone = true;
    }

    public void setNotDone() {
        this.isDone = false;
    }

    public String toString() {
        return "[T]" + super.toString();
    }

    public boolean isEquals(Object toCompare) {
        if (toCompare != null && toCompare.getClass() == getClass()) {
            if (this.isDone == ((Todo) toCompare).isDone) {
                return super.isEquals(toCompare);
            }
        }
        return false;
    }
}
