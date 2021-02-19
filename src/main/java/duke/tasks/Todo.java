package duke.tasks;


import java.util.Date;

/**
 * This is extend class inherited from Tasks.
 * adding todo task
 */
public class Todo extends Tasks {

    public Todo(String description, String time, String email) {
        super(description, time, email);
        super.type = "[T]";
    }


    public String toString() {

        return type + status + " " + description + " | " + time + " | " + email;
    }
}
