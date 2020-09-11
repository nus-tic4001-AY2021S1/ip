package Duke;

public abstract class Task {
    protected String description;
    protected boolean isDone;
    protected char type;
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    public Task(String description,char type) {
        this.description = description;
        this.isDone = false;
        this.type = type;
    }
    public Task(String description,char type,boolean isDone) {
        this.description = description;
        this.isDone = false;
        this.type = type;
        this.isDone=isDone;
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public void markAsDone(){
        this.isDone =true;
    }
    public abstract String toString();
    public abstract String printToFIle();
}
