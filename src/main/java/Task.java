abstract class Task {
    protected String description;

    //constructor
    public Task(String description) {
        this.description = description;
    }

    //abstract methods
    public abstract String getStatusIcon();
    // make abstract class
    public abstract void markAsDone();
    // make abstract class
    public abstract boolean getIsDone();

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + getDescription();
    }
}