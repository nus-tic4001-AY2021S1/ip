package duke.task;
/**
 * Inherits the Todo class to represent Event tasks.
 */
public class Event extends Todo {
    public Event(String input) {
        super(input);
        String[] split = input.split("/at");
    }
}
