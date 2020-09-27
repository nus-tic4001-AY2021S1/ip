package duke.task;

/**
 * Inherits the duke.task.Todo class to represent duke.task.Deadline tasks.
 */
public class Deadline extends Todo {
    public Deadline(String input) {
        super(input);
        String[] split = input.split("/by");
    }
}