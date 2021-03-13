package duke.command;

public class EventCommand extends Command {
    private String time;

    /**
     * @param content the content of the task
     * @param time the event time of task
     */
    public EventCommand(String content, String time) {
        this.time = time;
        this.type = "event";
        this.content = content;
    }

    public String getTime() {
        return time;
    }
}
