package Command;

public class DeadlineCommand extends Command {
    private String time;

    public DeadlineCommand(String content,String time) {
        this.type = "deadline";
        this.time = time;
        this.content = content;
    }

    public String getTime(){
        return time;
    }

}
