package Duke.Command;

public class DeadlineCommand extends Command {
    private String time;

    public DeadlineCommand(String content,String time) {
        this.time = time;
        this.type = "deadline";
        this.content = content;
    }

    public String getTime(){
        return time;
    }
}
