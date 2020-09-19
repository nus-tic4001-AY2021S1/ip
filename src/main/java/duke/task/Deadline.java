package duke.task;
/**
 * Inherits the Todo class to represent Deadline tasks.
 */
public class Deadline extends Todo {
    public Deadline(String input) {
        super(input);
        String[] split = input.split("/by");
    }
}