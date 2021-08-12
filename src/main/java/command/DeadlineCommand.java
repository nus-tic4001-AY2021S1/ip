package command;

public class DeadlineCommand extends Command {
    private String time;

    /**
     * @param content Task description
     * @param time Task deadline
     */
    public DeadlineCommand(String content, String time) {
        this.type = "deadline";
        this.time = time;
        this.content = content;
    }

    public String getTime() {
        return time;
    }
}
