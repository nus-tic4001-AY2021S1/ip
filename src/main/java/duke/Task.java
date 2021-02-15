package duke;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
    }

    //public String toString() {
    public abstract String toString(); /*{
        //return this.toString() ;
        return ("[" + this.getStatusIcon() + "] " +  this.description );
    }*/

    public String printTask() {
        //System.out.println("[" + this.getStatusIcon() + "] " +  this.description ) ;
        //Workable - System.out.println(this.toString());
        return this.toString();
    }

    public String getTask() {
        return this.description;
    }
}
