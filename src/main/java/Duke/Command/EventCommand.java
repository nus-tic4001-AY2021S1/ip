package Duke.Command;

public class EventCommand extends Command{
    private String time;

    public EventCommand(String content,String time) {
        this.time = time;
        this.type = "event";
        this.content = content;
    }

    public String getTime(){
        return time;
    }
}
