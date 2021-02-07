package duke.task;

/**
 * Inherits the duke.task.Todo class to represent duke.task.Event tasks.
 */

public class Event extends Todo {
    public Event(String input) {
        super(input);
        String[] split = input.split("/at");
    }
}
