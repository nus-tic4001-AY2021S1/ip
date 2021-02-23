package data;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected String tag;

    public Task() {
    }

    /**
     * Task Constructor.
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.tag = "";
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

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void unTag() {
        this.tag = "";
    }

    public String getTag() {
        return this.tag;
    }

    public boolean completionStatus() {
        return isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }


    /**
     * toString provides the implementation to print the object Task.
     * @return
     */
    public String toString() {
        String s;
        s = this.tag.isBlank() ? "" : "#" + this.tag;
        return String.format("[" + this.getTaskStatus() + "] %s " + s, this.getDescription());
    }

    public String save() {
        return this.getDescription().trim();
    }
}
