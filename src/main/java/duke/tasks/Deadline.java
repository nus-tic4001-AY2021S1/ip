package duke.tasks;

/**
 * To test Deadline, please run DeadlineTest
 */
public class Deadline extends Todo {
    protected String by;
    public Deadline(String description, String by){
        super(description);
        this.by=by;
    }
    public String toString(){
        return "[D]" + "["+getStatusIcon()+"]"+" "+getDescription() + " (by: " + by + ")";
    }
    public String getBy(){
        return by;
    }
}
