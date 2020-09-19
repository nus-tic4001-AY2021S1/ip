package duke.task;

public class Event extends Todo {
    private String[] split;

    public Event(String input) {
        super(input);
        split = input.split("/at");
    }
}
