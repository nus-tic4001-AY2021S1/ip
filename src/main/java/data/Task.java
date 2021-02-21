package data;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task() {
    }

    /**
     * Task Constructor.
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Return a check mark or cross.
     * @return
     */
    public String getTaskStatus() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return this.isDone;
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
        return String.format("["+ this.getTaskStatus() +"] %s", this.getDescription());
    }

    public String save() {
        return this.getDescription();
    }
}
