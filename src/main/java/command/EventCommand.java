package command;

public class EventCommand extends Command {
    private String time;

    /**
     * @param content event description
     * @param time event date and time
     */
    public EventCommand(String content, String time) {
        this.type = "event";
        this.time = time;
        this.content = content;
    }

    public String getTime() {
        return time;
    }
}

