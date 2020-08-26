package Duke.task;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task() {
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean completionStatus() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    public String toString() {
        return String.format("%s", this.getDescription());
    }
}