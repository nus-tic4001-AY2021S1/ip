package duke.command;

public class DeadlineCommand extends Command {
    private String time;

    /**
     * @param content deadline content
     * @param time the deadline time
     */
    public DeadlineCommand(String content, String time) {
        this.time = time;
        this.type = "deadline";
        this.content = content;
    }

    public String getTime() {
        return time;
    }
}
