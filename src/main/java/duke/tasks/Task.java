package duke.tasks;

public abstract class Task {
    protected String description;

    public Task(String description) {
        this.description = description;
    }

    public abstract String getStatusIcon();

    public abstract void setDone();

    public abstract boolean getIsDone();

    public boolean isEquals(Object toCompare) {
        if (toCompare != null && toCompare.getClass() == getClass()) {
            if (this.description.equals(((Task) toCompare).description)) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + getDescription();
    }

}
