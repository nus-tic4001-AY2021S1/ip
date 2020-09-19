package duke.task;

public class Deadline extends Todo {
    private String[] split;

    public Deadline(String input) {
        super(input);
        split = input.split("/by");
    }
}
