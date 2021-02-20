package duke.tasks;

import java.util.Date;

/**
 * This is extend class inherited from Tasks.
 * adding deadline task
 */

public class Deadline extends Tasks {


    public Deadline(String description, String time, String email) {
        super(description, time, email);
        super.type = "[D]";
    }

    public String toString() {
        return type + status + " " + description + " | " + time + " | " + email;
    }

}
