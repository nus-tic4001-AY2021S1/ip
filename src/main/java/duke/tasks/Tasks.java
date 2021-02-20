package duke.tasks;

import java.util.Date;

/**
 * An abstract class that is inherited by the duke.task.Todo, Deadline and Event classes.
 */

public class Tasks {

    protected String status;
    protected String description;
    protected String time;
    protected boolean isDone;
    protected String type;
    protected String email;


    public Tasks(String description, String time, String email) {
        this.description = description;
        this.status = "[x]";
        this.time = time;
        this.isDone = false;
        this.email = email;
    }

    public String toString() {

        return status + " " + description;
    }
}
