package Duke;

abstract class Task {
    protected String description;

    //constructor
    public Task(String description) {
        this.description = description;
    }

    //abstract methods
    public abstract String getStatusIcon();
    public abstract void markAsDone();
    public abstract boolean getIsDone();

    public String getDescription(){
        return this.description;
    }
    public String toString(){
        return "["+getStatusIcon()+"]" + " " + getDescription();
    }
}

