package duke.tasks;

import java.util.Date;

/**
 * This is extend class inherited from Tasks.
 * adding event task
 */

public class Event extends Tasks {

    public Event(String description, String time, String email) {
        super(description, time, email);
        super.type = "[E]";
    }

    public String toString() {
        return type + status + " " + description + " | " + time + " | " + email;
    }
}


